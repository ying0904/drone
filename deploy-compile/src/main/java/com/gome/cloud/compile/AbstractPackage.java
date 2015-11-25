package com.gome.cloud.compile;

import java.io.File;


public abstract class AbstractPackage implements Package {

	
	public String sourceCodeBasePath = "D://SourceCode";
	
	public abstract boolean checkOut(final String url, final String user, final String password, final long lastVersion) throws Exception;

	@Override
	public boolean compile() {
		return false;
	}

	@Override
	public boolean exportPackage(String[] url, String dirName) {
		return false;
	}
	
	public String getPrjectName(String url) {
		String[] strs = url.split("\\/");
		String[] ss = strs[strs.length-1].split("\\.");
		if (ss.length > 1) {
			return ss[ss.length - 1 - 1];
		} else {
			return ss[0];
		}
	}
	
	public File getWorksapce(String path) {
		File file = new File(sourceCodeBasePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File file2 = new File(sourceCodeBasePath + File.separator + path);
		if (!file2.exists()) {
			file2.mkdirs();
		}
		return file2;
	} 
	
}
