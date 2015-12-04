/**
 * 
 */
package com.gome.cloud.compile.source;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.gome.cloud.compile.AbstractPackage;
import com.gome.cloud.compile.PackageBean;

/**
 * @author blaiu
 *
 */
public class SvnSource extends AbstractPackage {

	private static final String SVN = "SVN";
	
	/**
	 * 初始化不同协议
	 */
	private void setup () {  
        DAVRepositoryFactory.setup();  
        SVNRepositoryFactoryImpl.setup();  
        FSRepositoryFactory.setup();  
    }
	
	/**
	 * SVN client认证
	 * @param repository
	 * @param username
	 * @param password
	 * @return
	 * @throws SVNException
	 */
	private SVNClientManager auth(SVNRepository repository, String username, String password) throws SVNException {  
		setup();  
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password.toCharArray());  
        repository.setAuthenticationManager(authManager);  
        DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(true);  
        SVNClientManager clientManager = SVNClientManager.newInstance(options, authManager);  
        return clientManager;  
    }
	
	/**
	 * 代码同步更新
	 * @param clientManager
	 * @param url
	 * @param revision
	 * @param destPath
	 * @param depth
	 * @return
	 * @throws SVNException
	 */
	private long update(SVNClientManager clientManager, SVNURL url, SVNRevision revision, File destPath, SVNDepth depth) throws SVNException {  
        SVNUpdateClient updateClient = clientManager.getUpdateClient();  
        updateClient.setIgnoreExternals(false);  
        return updateClient.doCheckout(url, destPath, revision, revision, depth, false);  
    }
	
//	/**
//	 * 代码更新
//	 * @param clientManager
//	 * @param wcPath
//	 * @param updateToRevision
//	 * @param depth
//	 * @return
//	 * @throws SVNException
//	 */
//	private long update(SVNClientManager clientManager, File wcPath, SVNRevision updateToRevision, SVNDepth depth) throws SVNException {  
//        SVNUpdateClient updateClient = clientManager.getUpdateClient();  
//        updateClient.setIgnoreExternals(false);  
//        return updateClient.doUpdate(wcPath, updateToRevision, depth, false, false);  
//    }
	
	@Override
	public PackageBean checkOut(PackageBean pb) throws SVNException, IOException {
		setup();  
        SVNRepository repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(pb.getUrl()));  
		SVNClientManager clientManager = auth(repository, pb.getUser(), pb.getPassword());
		if (null == clientManager) {
			return pb;
		}
		pb.setProjectName(getPrjectName(pb.getExtractPackagePath()));
		pb.setCheckoutAppName(getPrjectName(pb.getUrl()));
		pb.setSourcePath(getWorksapce(SVN + File.separator + pb.getUser() + File.separator + pb.getDomain() + File.separator + pb.getCheckoutAppName()).getAbsolutePath());
		pb.setTargetPath(getWorksapce(SVN + File.separator + pb.getUser() + File.separator + pb.getDomain() + File.separator + exceptPrefix (pb.getExtractPackagePath())).getAbsolutePath() + File.separator + "target");
		
		SVNURL repositoryURL = SVNURL.parseURIEncoded(pb.getUrl());
		File ws = new File(pb.getSourcePath());
		
		long lastVersion = update(clientManager, repositoryURL, SVNRevision.HEAD, ws, SVNDepth.INFINITY);
		pb.setLastVersion(lastVersion + "");
		pb.setLogPath(printLog(pb, repository));
		return pb;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String printLog(PackageBean pb, SVNRepository repository) throws SVNException {
		String dirLog = createWorksapce(logPath, pb.getDomain() + File.separator + pb.getTaskId(), "");
		File file = new File(dirLog + File.separator +"compile.log");
		FileWriter writer = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new FileWriter(file, true);
			Collection<SVNLogEntry> logEntries = repository.log(new String[] {"/"} , null , Long.valueOf(pb.getPreVersion()) , -1 , true , true);
			for (Iterator<SVNLogEntry> entries = logEntries.iterator(); entries.hasNext();) {
				SVNLogEntry logEntry = entries.next();
				writer.write("------------------- svn info ------------------------\n");
				writer.write("date: " + logEntry.getDate() + " author: " + logEntry.getAuthor() + " revision: " + logEntry.getRevision() + " log message: " + logEntry.getMessage() +"\n");
				
				if (logEntry.getChangedPaths().size() > 0) {
					writer.write("changed paths:");
					Set changedPathsSet = logEntry.getChangedPaths().keySet();
					for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) {
						SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry.getChangedPaths().get( changedPaths.next());
						writer.write(entryPath.getType() + " "
				  								 + entryPath.getPath() 
				  								 + (( entryPath.getCopyPath() != null ) ? " (from " + entryPath.getCopyPath() + " revision " + entryPath.getCopyRevision() + ")" : " \n"));
					}
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
	
//	public static void main(String[] args) throws Exception {
//		PackageBean pb = new PackageBean();
//		pb.setUrl("http://10.58.44.86/repos/gmfs/branches/gomefile-sdk");
//		pb.setUser("fangbin");
//		pb.setPassword("123456");
//		pb.setTaskId("1002");
//		pb.setDomain("gfs.gome.com.cn");
//		pb.setExtractPackagePath("/gomefile-sdk");
//		pb.setPreVersion("756");
//		
//		SvnSource svnSource = new SvnSource();
//		try {
//			svnSource.compile(pb);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
