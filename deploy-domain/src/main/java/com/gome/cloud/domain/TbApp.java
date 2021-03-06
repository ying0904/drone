/**
 * 
 */
package com.gome.cloud.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author blaiu
 *
 */
public class TbApp {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String projectId;
	@Getter
	@Setter
	private String appId;
	
	@Getter
	@Setter
	private String appName;
	@Getter
	@Setter
	private String appChineseName;
	@Getter
	@Setter
	private Integer appType;
	@Getter
	@Setter
	private Integer appLevel;
	@Getter
	@Setter
	private String appChief;
	
	@Getter
	@Setter
	private Integer domainType;
	@Getter
	@Setter
	private String appDomain;
	
	@Getter
	@Setter
	private Integer deployType;
	@Getter
	@Setter
	private String deployPath;
	
	@Getter
	@Setter
	private Integer compileType;
	@Getter
	@Setter
	private Integer status;
	
	@Getter
	@Setter
	private String createUser;
	@Getter
	@Setter
	private Date createTime;
	@Getter
	@Setter
	private String updateUser;
	@Getter
	@Setter
	private Date updateTime;
	
	@Getter
	@Setter
	private String remark;
	@Getter
	@Setter
	private Integer isDel;
	
	
	
}
