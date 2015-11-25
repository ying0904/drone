/**
 * 
 */
package com.gome.cloud.compile;

import java.io.File;

import com.gome.cloud.compile.util.GitUtil;

/**
 * @author blaiu
 *
 */
public class GitSource extends AbstractPackage {

	private static final String Git = "Git";
	
	@Override
	public boolean checkOut(final String url, final String user, final String password, final long lastVersion) throws Exception {
		String projectName = getPrjectName(url);
		File workspace = getWorksapce(Git + File.separator + user);
		GitUtil.pull(url, workspace, projectName, user, password);
		return false;
	}

	public static void main(String[] args) {
		GitSource gitSource = new GitSource();
		try {
			gitSource.checkOut("https://github.com/blaiu/deploy", "blaiu", "blaiu123", -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
