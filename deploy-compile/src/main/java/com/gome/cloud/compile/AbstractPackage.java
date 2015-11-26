package com.gome.cloud.compile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public abstract class AbstractPackage implements Package {

	
	public String sourceCodeBasePath = "/sourceworksapce";
	
	public String compilePath = "/compileworksapce";
	
	public String logPath = "/compilelog";
	
	public final static String BUILD = "build";
	public final static String TEST = "test";
	
	
	public abstract PackageBean checkOut(PackageBean pb) throws Exception;

	@Override
	public PackageBean compile(PackageBean pb) {
		InputStream in = null;
		Process p = null;
		try { 
			pb = checkOut(pb);
			pb.setCompileBuildPath(createWorksapce(compilePath, pb.getTaskId(), BUILD));
			pb.setCompileTestPath(createWorksapce(compilePath, pb.getTaskId(), TEST));
			if(!isLinux()) {
				p = Runtime.getRuntime().exec(
				        "cmd /c cd " + pb.getAppPath()
				        + "&&call mvn clean -U install " + getProfileId (pb.getProductPid()) + " -Dmaven.test.skip=true"
				        + "&&rd /s /q " + pb.getCompileBuildPath()
				        + "&&md " + pb.getCompileBuildPath()
				        + "&&echo copy the file"
				        + "&&xcopy " + pb.getTargetPath() + " " + pb.getCompileBuildPath() + " /e /y"
				        + "&&cd " + pb.getAppPath()
				        + "&&call mvn clean -U install " + getProfileId (pb.getTestPid()) + " -Dmaven.test.skip=true"
				        + "&&rd /s /q " + pb.getCompileTestPath()
				        + "&&md " + pb.getCompileTestPath()
				        + "&&echo copy the file"
				        + "&&xcopy " + pb.getTargetPath() + " " + pb.getCompileTestPath() + " /e /y"
				        );
			} else {
				p = Runtime.getRuntime().exec(  
				        "cd " + pb.getAppPath()  
				        + ";mvn clean -U package -Dtest -DfailIfNoTests=false -P" + getProfileId (pb.getTestPid())  
				        + ";rm -rf " + pb.getCompileTestPath()  
				        + ";mkdir -p " + pb.getCompileTestPath()  
				        + ";cp -rf " + pb.getTargetPath() + File.separator + "* "+ pb.getCompileTestPath()  
				        + ";cd " + pb.getAppPath() 
				        + ";mvn clean -U package -Dtest -DfailIfNoTests=false -P" + getProfileId (pb.getProductPid())  
				        + ";rm -rf " + pb.getCompileBuildPath()  
				        + ";mkdir -p " + pb.getCompileBuildPath()  
				        + ";cp -rf " + pb.getTargetPath() + File.separator + "* "+ pb.getCompileBuildPath() 
				        );
			}
			in = p.getInputStream();
			pb.setLogPath(writeLog(in, pb.getTaskId()));
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally {  
			if (in != null) {  
				try {  
					in.close();  
				} catch (Exception e) {  
				}  
			}  
		} 
		return pb;
	}
	
	private String getProfileId (String profileId) {
		if (null != profileId && !profileId.trim().equals("")) {
			return "-P" + profileId;
		}
		return "";
	}
	
	private boolean isLinux() {
		String sysName = System.getProperties().getProperty("os.name");
		if (sysName.toUpperCase().contains("WIN")) {
			return false;
		} else {
			return true;
		}
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
	
	/**
	 * 源码存放路径
	 * @param path
	 * @return
	 */
	public File getWorksapce(String path) {
		File sourceFile = new File(sourceCodeBasePath);
		if (!sourceFile.exists()) {
			sourceFile.mkdirs();
		}
		File sourcefile2 = new File(sourceCodeBasePath + "\\" + path);
		if (!sourcefile2.exists()) {
			sourcefile2.mkdirs();
		}
		return sourcefile2;
	} 
	
	/**
	 * 创建工作区
	 * @param path
	 * @param taskId
	 * @param flag
	 * @return
	 */
	public String createWorksapce(String path, String taskId, String flag) {
		String filePath = path + File.separator + flag + File.separator + taskId;
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
	
	public String getTarget(File appPath) {
		File file = new File(appPath.getAbsolutePath() + File.separator + "target");
		if (!file.exists()) {
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
	
	public String writeLog(InputStream in, String taskId) {
		String dirLog = createWorksapce(logPath, taskId, "");
		File file = new File(dirLog + File.separator + "compile.log");
		BufferedReader br = null;
		FileWriter writer = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			br = new BufferedReader(new InputStreamReader(in, "GBK"));
			writer = new FileWriter(file, true);
			String line = null;
			writer.write("------------------- maven compile info ------------------------\n");
			while ((line = br.readLine()) != null) {  
				writer.write(line + "\n");
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
			if (null != br ) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		} 
		return file.getAbsolutePath();
	}
	
}
