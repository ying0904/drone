/**
 * 
 */
package com.gome.cloud.domain;

import java.util.Date;

/**
 * @author blaiu
 *
 */
public class TbApp {

	private Integer id;
	private Integer appId;
	private Integer systemId;
	
	private String appName;
	private String appChineseName;
	private Integer appLevel;
	private Integer appType;
	private String appChief;
	
	private Integer domainType;
	private String appDomain;
	
	private Integer deployType;
	private String deployPath;
	
	private Integer compileType;
	
	private Integer status;
	
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
	
	private String remark;
	private Integer isDel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppChineseName() {
		return appChineseName;
	}
	public void setAppChineseName(String appChineseName) {
		this.appChineseName = appChineseName;
	}
	public Integer getAppLevel() {
		return appLevel;
	}
	public void setAppLevel(Integer appLevel) {
		this.appLevel = appLevel;
	}
	public Integer getAppType() {
		return appType;
	}
	public void setAppType(Integer appType) {
		this.appType = appType;
	}
	public String getAppChief() {
		return appChief;
	}
	public void setAppChief(String appChief) {
		this.appChief = appChief;
	}
	public Integer getDomainType() {
		return domainType;
	}
	public void setDomainType(Integer domainType) {
		this.domainType = domainType;
	}
	public String getAppDomain() {
		return appDomain;
	}
	public void setAppDomain(String appDomain) {
		this.appDomain = appDomain;
	}
	public Integer getDeployType() {
		return deployType;
	}
	public void setDeployType(Integer deployType) {
		this.deployType = deployType;
	}
	public String getDeployPath() {
		return deployPath;
	}
	public void setDeployPath(String deployPath) {
		this.deployPath = deployPath;
	}
	public Integer getCompileType() {
		return compileType;
	}
	public void setCompileType(Integer compileType) {
		this.compileType = compileType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}
