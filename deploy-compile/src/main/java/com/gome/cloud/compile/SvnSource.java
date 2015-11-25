/**
 * 
 */
package com.gome.cloud.compile;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;

import com.gome.cloud.compile.util.SVNUtil;

/**
 * @author blaiu
 *
 */
public class SvnSource extends AbstractPackage {

	private static final String SVN = "SVN";
	
	/**
	 * 初始化不同版本的SVN协议
	 */
	public static void setup () {  
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup(); 
        FSRepositoryFactory.setup();
    }
	
	@Override
	public boolean checkOut(final String url, final String user, final String password, final long preVersion ) throws SVNException {
		setup();  
        SVNRepository repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));  
		SVNClientManager clientManager = SVNUtil.auth(repository, user, password);
		if (null == clientManager) {
			return false;
		}
		
		String projectName = getPrjectName(url);
		File workspace = getWorksapce(SVN + File.separator + user);
		
		SVNURL repositoryURL = SVNURL.parseURIEncoded(url);
		File ws = new File(workspace, projectName);
		long lastVersion = SVNUtil.checkout(clientManager, repositoryURL, SVNRevision.HEAD, ws, SVNDepth.INFINITY);
		printLog(repository, preVersion);
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void printLog(SVNRepository repository, long preVersion) throws SVNException {
		Collection<SVNLogEntry> logEntries = repository.log(new String[] { "/" } , null , 756 , -1 , true , true);
		for ( Iterator<SVNLogEntry> entries = logEntries.iterator( ); entries.hasNext( ); ) {
			SVNLogEntry logEntry = entries.next( );
			System.out.println( "---------------------------------------------" );
			System.out.println ("revision: " + logEntry.getRevision( ) );
			System.out.println( "author: " + logEntry.getAuthor( ) );
			System.out.println( "date: " + logEntry.getDate( ) );
			System.out.println( "log message: " + logEntry.getMessage( ) );
			
			if ( logEntry.getChangedPaths( ).size( ) > 0 ) {
				System.out.println( );
				System.out.println( "changed paths:" );
				Set changedPathsSet = logEntry.getChangedPaths( ).keySet( );

				for (Iterator changedPaths = changedPathsSet.iterator( ); changedPaths.hasNext( );) {
					SVNLogEntryPath entryPath = ( SVNLogEntryPath ) logEntry.getChangedPaths( ).get( changedPaths.next( ) );
					System.out.println( " " + entryPath.getType( )
			  								 + " "
			  								 + entryPath.getPath( )
			  								 + ( ( entryPath.getCopyPath( ) != null ) ? " (from "
					  						 + entryPath.getCopyPath( ) + " revision "
											 + entryPath.getCopyRevision( ) + ")" : "" ) );
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SvnSource svnSource = new SvnSource();
		try {
			svnSource.checkOut("http://10.58.44.86/repos/gmfs/branches/gomefile-sdk", "fangbin", "123456", 756);
		} catch (SVNException e) {
			e.printStackTrace();
		}
	}

}
