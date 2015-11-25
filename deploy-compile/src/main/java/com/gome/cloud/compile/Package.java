/**
 * 
 */
package com.gome.cloud.compile;

/**
 * @author blaiu
 *
 */
public interface Package {

	public boolean compile();
	
	public boolean exportPackage(String[] url, String dirName);
	
}
