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
public class TbOnlineTaskPackage {

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String taskId;

	@Getter
	@Setter
	private String packageId;
	
	@Getter
	@Setter
	private String packageName;
	
	@Getter
	@Setter
	private String packagPath;
	
	@Getter
	@Setter
	private Integer type;
	
	@Getter
	@Setter
	private Date createTime;
	
	@Getter
	@Setter
	private String createUser;
	
	@Getter
	@Setter
	private String UUID;
	
}
