package com.gome.cloud.compile;

public class PackageBean {

	/** source url */
	private String url;
	/** source user */
	private String user;
	/** source pass */
	private String password;
	
	/** 更新名称 */
	private String checkoutAppName;
	
	/** 任务号 */
	private String taskId;
	
	/** 项目名*/
	private String projectName;
	
	/** 抽包地址 */
	private String extractPackagePath;
	
//	/** 应用名称 */
//	private String appName;
	/** 域名 */
	private String domain;
//	/** 应用地址 */
//	private String appPath;
	/** 最后一次更新版本 */
	private String lastVersion;
	/** 最后一次更新版本 */
	private String preVersion;
	/** 日志存放地址*/
	private String logPath;
	
	/** 存放地址 */
	private String sourcePath;
	/** 编译后文件存放地址*/
	private String compileBuildPath;
	/** 编译后文件存放地址*/
	private String compileTestPath;
	
	/** 编译后文件存放地址*/
	private String targetPath;
	
	/** 测试profile */
	private String testPid;
	
	/** 生产profile */
	private String productPid;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	
	
//	public String getAppName() {
//		return appName;
//	}
//
//	public void setAppName(String appName) {
//		this.appName = appName;
//	}

//	public String getAppPath() {
//		return appPath;
//	}
//
//	public void setAppPath(String appPath) {
//		this.appPath = appPath;
//	}

	public String getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public String getCompileBuildPath() {
		return compileBuildPath;
	}

	public void setCompileBuildPath(String compileBuildPath) {
		this.compileBuildPath = compileBuildPath;
	}

	public String getCompileTestPath() {
		return compileTestPath;
	}

	public void setCompileTestPath(String compileTestPath) {
		this.compileTestPath = compileTestPath;
	}

	public String getTestPid() {
		return testPid;
	}

	public void setTestPid(String testPid) {
		this.testPid = testPid;
	}

	public String getProductPid() {
		return productPid;
	}

	public void setProductPid(String productPid) {
		this.productPid = productPid;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public String getCheckoutAppName() {
		return checkoutAppName;
	}

	public void setCheckoutAppName(String checkoutAppName) {
		this.checkoutAppName = checkoutAppName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPreVersion() {
		return preVersion;
	}

	public void setPreVersion(String preVersion) {
		this.preVersion = preVersion;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getExtractPackagePath() {
		return extractPackagePath;
	}

	public void setExtractPackagePath(String extractPackagePath) {
		this.extractPackagePath = extractPackagePath;
	}
	
	
	
}
