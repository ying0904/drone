/**
 * 
 */
package com.gome.cloud.compile.ceph;

import java.io.File;

/**
 * @author blaiu
 *
 */
public interface ICeph {

	public String upLoad(File file);

	public String upLoad(File file, String rename);

	public String upLoad(String filePath);
	
	public String upLoad(String filePath, String rename);
	
	public void downLoad(String fileName, String descPath);
	
	public void downLoad(String fileName, File descDir);
	
	
	
}
