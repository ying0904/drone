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
public class TbDeployTask {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	@Getter
	@Setter
	private String deployId;
	@Getter
	@Setter
	private String taskId;
	
	@Getter
	@Setter
	private String approvalUser;
	@Getter
	@Setter
	private Date approvalTime;
	
	@Getter
	@Setter
	private String title;
	@Getter
	@Setter
	private String planDeployTime;
	
	@Getter
	@Setter
	private String remark;
	@Getter
	@Setter
	private String versionSrc;
	@Getter
	@Setter
	private String VersionNo;
	
	@Getter
	@Setter
	private String createUser;
	
	@Getter
	@Setter
	private String createTime;
	
	@Getter
	@Setter
	private Integer status;
	
	@Getter
	@Setter
	private Date finishTime;
	
	@Getter
	@Setter
	private String UUID;
	
}
