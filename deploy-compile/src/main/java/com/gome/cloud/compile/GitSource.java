/**
 * 
 */
package com.gome.cloud.compile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.RenameDetector;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.StringUtils;


/**
 * @author blaiu
 *
 */
public class GitSource extends AbstractPackage {

	private final static String GIT = ".git"; 
	private static final String git = "Git";
	
	private UsernamePasswordCredentialsProvider auth (String user, String password) throws IOException {
		if (!StringUtils.isEmptyOrNull(user) && !StringUtils.isEmptyOrNull(password)) {
			return new UsernamePasswordCredentialsProvider(user, password);
		}
		return null;
	}
	
	private Repository cloneRepository(PackageBean pb, UsernamePasswordCredentialsProvider credentialsProvider) throws InvalidRemoteException, TransportException, GitAPIException, IOException {
		File destFile = new File(pb.getSourcePath());
		File cloneFile = new File(destFile.getAbsolutePath() + File.separator + GIT);
		Repository repository = null;
		if (!cloneFile.exists()) {  
			CloneCommand command = Git.cloneRepository();
			if (null != credentialsProvider) {
				command.setCredentialsProvider(credentialsProvider);
			}
			Git result = command.setURI(pb.getUrl()).setDirectory(destFile).call();
			repository = result.getRepository();
		} else {
			repository = Git.open(destFile).getRepository();
		}
		return repository;
	}
	
	private void pull (PackageBean pb) throws Exception {
		UsernamePasswordCredentialsProvider credentialsProvider = auth(pb.getUser(), pb.getPassword());
		Repository repository = cloneRepository(pb, credentialsProvider);
		Git git = new Git(repository);
		PullCommand command = git.pull();
		if (null != credentialsProvider) {
			command.setCredentialsProvider(credentialsProvider);
		}
		PullResult result = command.call();
		Ref ref = result.getFetchResult().getAdvertisedRef("refs/heads/master");
		pb.setLogPath(printLog (pb, git, ref));
		git.close();
	}
	
	private String printLog (PackageBean pb, Git git, Ref ref) throws InvalidRefNameException, GitAPIException, CorruptObjectException, IOException {
		String dirLog = createWorksapce(logPath, pb.getDomain() + File.separator + pb.getTaskId(), "");
		File file = new File(dirLog + File.separator +"compile.log");
		FileWriter writer = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new FileWriter(file, true);
			ObjectId objId = git.getRepository().resolve(pb.getPreVersion());
			Collection<ReflogEntry> call = git.reflog().setRef(ref.getName()).call();
			Iterator<ReflogEntry> it = call.iterator();
			while (it.hasNext()) {
				ReflogEntry reflog = it.next();
				if (null != pb.getLastVersion() && !"".equals(pb.getLastVersion().trim())) {
					pb.setLastVersion(reflog.getNewId().getName());
				}
				Iterable<RevCommit> allCommitsLater = git.log().add(objId).call();
				Iterator<RevCommit> iter = allCommitsLater.iterator();
				while (iter.hasNext()) {
					RevCommit commit = iter.next(); 
					TreeWalk tw = new TreeWalk(git.getRepository());  
					tw.addTree(commit.getTree());  
					String comment = commit.getFullMessage();
					writer.write("comment:" + comment + "\n");
					commit = iter.next();
					if (commit != null) {  
						tw.addTree(commit.getTree());  
					} else {  
						break;  
					}  
					tw.setRecursive(true);  
					RenameDetector rd = new RenameDetector(git.getRepository()); 
					rd.addAll(DiffEntry.scan(tw));  
					List<DiffEntry> diffEntries = rd.compute(); 
					if (diffEntries == null || diffEntries.size() == 0) {  
						break;  
					} 
					
					Iterator<DiffEntry> iterator = new ArrayList<DiffEntry>(diffEntries).iterator();  
					DiffEntry diffEntry = null;  
					StringBuilder builder = new StringBuilder();
					while (iterator.hasNext()) { 
						diffEntry = iterator.next(); 
						builder.append(" author:" + reflog.getWho().getEmailAddress());
						builder.append(" Date:" + reflog.getWho().getWhen());
						builder.append(" changeType:" + diffEntry.getChangeType());
						builder.append(" newPath:" + diffEntry.getNewPath());
						builder.append(" oldPath:" + diffEntry.getOldPath());
						builder.append(" \n");
					} 
					writer.write(builder.toString());
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		} 
		return file.getAbsolutePath();
	}
	
	@Override
	public PackageBean checkOut(PackageBean pb) throws Exception {
		pb.setProjectName(getPrjectName(pb.getExtractPackagePath()));
		pb.setCheckoutAppName(getPrjectName(pb.getUrl()));
		pb.setSourcePath(getWorksapce(git + File.separator + pb.getUser() + File.separator + pb.getDomain() + File.separator + pb.getCheckoutAppName()).getAbsolutePath());
		pb.setTargetPath(sourceCodeBasePath + File.separator + git + File.separator + pb.getUser() + File.separator + pb.getDomain() + File.separator + exceptPrefix (pb.getExtractPackagePath()) + File.separator + "target");
		
		//		pb.setTargetPath(pb.getSourcePath() + File.separator + pb.getAppName() + File.separator + "target");
//		File workspace = getWorksapce(git + File.separator + pb.getUser());
//		File file = new File(workspace.getAbsolutePath() + File.separator + pb.getCheckoutAppName() + File.separator + pb.getAppName());
		pull(pb);
		return pb;
	}

	public static void main(String[] args) {
		GitSource gitSource = new GitSource();
		try {
			PackageBean pb = new PackageBean();
			pb.setUrl("https://github.com/blaiu/deploy");
			pb.setUser("blaiu");
			pb.setPassword("blaiu123");
			pb.setTaskId("1001");
			pb.setDomain("deploy.gome.com.cn");
			pb.setExtractPackagePath("/deploy/deploy-web");
			pb.setPreVersion("603bfdb1897cd0102e3c8c1affe9007192dd693f");
			gitSource.compile(pb);
//			gitSource.checkOut("https://github.com/blaiu/deploy", "blaiu", "blaiu123", -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
