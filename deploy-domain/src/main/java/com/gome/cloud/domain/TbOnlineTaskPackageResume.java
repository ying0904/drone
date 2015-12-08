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
public class TbOnlineTaskPackageResume {

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String taskId;
	
	@Getter
	@Setter
	private Integer status;
	
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
