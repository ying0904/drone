/**
 * 
 */
package com.gome.cloud.domain;

import java.util.Date;

/**
 * @author blaiu
 *
 */
public class TbAppSystem {

	private Integer id;
	private Integer systemId;
	
	private String systemName;
	private String systemChineseName;
	private Integer systemLevel;
	private String systemChief;
	private String department;
	
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
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemChineseName() {
		return systemChineseName;
	}
	public void setSystemChineseName(String systemChineseName) {
		this.systemChineseName = systemChineseName;
	}
	public Integer getSystemLevel() {
		return systemLevel;
	}
	public void setSystemLevel(Integer systemLevel) {
		this.systemLevel = systemLevel;
	}
	public String getSystemChief() {
		return systemChief;
	}
	public void setSystemChief(String systemChief) {
		this.systemChief = systemChief;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
