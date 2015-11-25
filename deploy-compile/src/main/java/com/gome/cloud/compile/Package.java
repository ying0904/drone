/**
 * 
 */
package com.gome.cloud.compile;

/**
 * @author blaiu
 *
 */
public interface Package {

	public boolean checkOut(String url, String user, String password);
	
	public boolean compile();
	
	public boolean exportPackage(String[] url, String dirName);
	
}
