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
public class TbAppSourceCode {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	
	@Getter
	@Setter
	private String sourceType;
	@Getter
	@Setter
	private String trunk;
	@Getter
	@Setter
	private String trunkUser;
	@Getter
	@Setter
	private String trunkPassword;
	
	@Getter
	@Setter
	private String branch;
	@Getter
	@Setter
	private String branchUser;
	@Getter
	@Setter
	private String branchPassword;
	
	@Getter
	@Setter
	private String trunkLastVersion;
	@Getter
	@Setter
	private String branchLastVersion;
	
	
	@Getter
	@Setter
	private String targetPath;
	
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
	private Integer isDel;
	
	
	
}
