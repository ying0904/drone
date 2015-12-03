/**
 * 
 */
package com.gome.cloud.compile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author blaiu
 *
 */
public class CMD {

	public static void main(String[] args) {
		long startnum = getLines();
		start();
		long endnum = getLines();
		getLog(startnum, endnum);
		
//		Runtime runTime = Runtime.getRuntime();
//		Process pro = runTime.exec( new String[]{"/bin/sh","-c", command});
//		Process pro;
		
//		try {
//			pro = runTime.exec(new String[]{"/bin/sh","-c", "call /app/apache-tomcat-7.0.61/bin/startup.sh;exit"});
//			pro = runTime.exec("cmd /c cd D:\\dev\\server\\apache-tomcat-7.0.61\\bin&&call startup.bat start", null, new File("D:\\dev\\server\\"));
//			InputStream fis = pro.getInputStream();			
//			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");			
//			BufferedReader br = new BufferedReader(isr);			
//			String line;			
//			StringBuilder build = new StringBuilder();			
//			while ((line = br.readLine()) != null) {				
//				build.append(line+"\r\n");		
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	
	private static void start() {
		Runtime runTime = Runtime.getRuntime();
		Process pro;
		try {
			pro = runTime.exec(new String[]{"/bin/sh","-c", "/app/apache-tomcat-7.0.61/bin/startup.sh"});
			InputStream fis = pro.getInputStream();			
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");			
			BufferedReader br = new BufferedReader(isr);			
			String line;			
			StringBuilder build = new StringBuilder();			
			while ((line = br.readLine()) != null) {				
				build.append(line+"\r\n");		
				System.out.println(line);
			}
			Thread.sleep(1000 * 45);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static long getLines() {
		Runtime runTime = Runtime.getRuntime();
		Process pro;
		long statnum = 0;
		try {
			pro = runTime.exec( new String[]{"/bin/sh","-c", " wc -l /app/apache-tomcat-7.0.61/logs/catalina.out"});
			InputStream fis = pro.getInputStream();			
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");			
			BufferedReader br = new BufferedReader(isr);			
			String line;			
			StringBuilder build = new StringBuilder("");			
			while ((line = br.readLine()) != null) {				
				build.append(line+"\r\n");		
			}
			String numstr = build.toString();
			if (null != numstr && !numstr.trim().isEmpty()) {
				statnum = Long.valueOf(numstr.split(" ")[0]);
				System.out.println(numstr.split(" ")[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statnum;
	}
	
	private static void getLog(long startnum, long endnum) {
		Runtime runTime = Runtime.getRuntime();
		Process pro;
		try {
			System.out.println();
			pro = runTime.exec( new String[]{"/bin/sh","-c", "head -n " + endnum + " /app/apache-tomcat-7.0.61/logs/catalina.out | tail -n +" + startnum});
			InputStream fis = pro.getInputStream();			
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");			
			BufferedReader br = new BufferedReader(isr);			
			String line;			
			StringBuilder build = new StringBuilder("");			
			while ((line = br.readLine()) != null) {				
				build.append(line+"\r\n");		
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
