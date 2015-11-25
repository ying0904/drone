package com.gome.cloud.compile.util;

import java.io.File;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
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

/**
 * 
 * @author blaiu
 *
 */
public class SVNUtil {

	/**
	 * 初始化不同协议
	 */
	public static void setup () {  
        DAVRepositoryFactory.setup();  
        SVNRepositoryFactoryImpl.setup();  
        FSRepositoryFactory.setup();  
    }
	
	public static SVNClientManager auth(SVNRepository repository, String username, String password) throws SVNException {  
		setup();  
//        SVNRepository repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(svnRoot));  
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password.toCharArray());  
        repository.setAuthenticationManager(authManager);  
        DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(true);  
        SVNClientManager clientManager = SVNClientManager.newInstance(options, authManager);  
        return clientManager;  
    }
	
	public static long checkout(SVNClientManager clientManager, SVNURL url, SVNRevision revision, File destPath, SVNDepth depth) throws SVNException {  
        SVNUpdateClient updateClient = clientManager.getUpdateClient();  
        updateClient.setIgnoreExternals(false);  
        return updateClient.doCheckout(url, destPath, revision, revision, depth, false);  
    }
	
	public static long update(SVNClientManager clientManager, File wcPath, SVNRevision updateToRevision, SVNDepth depth) throws SVNException {  
        SVNUpdateClient updateClient = clientManager.getUpdateClient();  
        updateClient.setIgnoreExternals(false);  
        return updateClient.doUpdate(wcPath, updateToRevision, depth, false, false);  
    } 
	
}
