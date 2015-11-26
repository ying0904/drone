/**
 * 
 */
package com.gome.cloud.compile;


/**
 * @author blaiu
 *
 */
public interface Package {

	
	/**
	 * maven 编译接口
	 * @return
	 */
	public PackageBean compile(PackageBean pb);
	
	public boolean exportPackage(String[] url, String dirName);
	
}
