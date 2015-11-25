/**
 * 
 */
package com.gome.cloud.compile.util;

import java.io.File;
import java.io.IOException;
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
public class GitUtil {

	private final static String GIT = ".git"; 
	
	public static UsernamePasswordCredentialsProvider auth (String user, String password) throws IOException {
		if (!StringUtils.isEmptyOrNull(user) && !StringUtils.isEmptyOrNull(password)) {
			return new UsernamePasswordCredentialsProvider(user, password);
		}
		return null;
	}
	
	public static Repository cloneRepository(String url, File dest, String projectName, String user, String password) throws InvalidRemoteException, TransportException, GitAPIException, IOException {
		File destFile = new File(dest.getAbsoluteFile().getAbsolutePath() + File.separator + projectName);
		File cloneFile = new File(destFile.getAbsoluteFile().getAbsolutePath() + File.separator + GIT);
		Repository repository = null;
		if (!cloneFile.exists()) {  
			CloneCommand command = Git.cloneRepository();
			UsernamePasswordCredentialsProvider credentialsProvider = auth(user, password);
			if (null != credentialsProvider) {
				command.setCredentialsProvider(credentialsProvider);
			}
			Git result = command.setURI(url).setDirectory(destFile).call();
			repository = result.getRepository();
		} else {
			repository = Git.open(destFile).getRepository();
		}
		return repository;
	}
	
	public static void pull (String url, File dest, String projectName, String user, String password) throws Exception {
		Repository repository = cloneRepository(url, dest, projectName, user, password);
		Git git = new Git(repository);
		PullCommand command = git.pull();
		UsernamePasswordCredentialsProvider credentialsProvider = auth(user, password);
		if (null != credentialsProvider) {
			command.setCredentialsProvider(credentialsProvider);
		}
		PullResult result = command.call();
		
		List<Ref> refs = new ArrayList<Ref>(result.getFetchResult().getAdvertisedRefs());
		printLog (git, refs);
		git.close();
	}
	
	public static void printLog (Git git, List<Ref> refs) throws InvalidRefNameException, GitAPIException, CorruptObjectException, IOException {
		for (Ref ref : refs) {
			Collection<ReflogEntry> call = git.reflog().setRef(ref.getName()).call();
			Iterator<ReflogEntry> it = call.iterator();
			while (it.hasNext()) {
				ReflogEntry reflog = it.next();
				Iterable<RevCommit> allCommitsLater = git.log().add(reflog.getNewId()).call();  
                Iterator<RevCommit> iter = allCommitsLater.iterator(); 
                RevCommit commit = iter.next();  
                TreeWalk tw = new TreeWalk(git.getRepository());  
                tw.addTree(commit.getTree());  
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
                    builder.append(" comment:" + reflog.getComment());
                    builder.append(" /n");
                    System.out.println(builder.toString());
                    iterator.remove();  
                } 
			}
		}
	}
	
	
	
}
