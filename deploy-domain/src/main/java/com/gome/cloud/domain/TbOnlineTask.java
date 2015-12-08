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
public class TbOnlineTask {

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String appId;
	
	@Getter
	@Setter
	private String taskId;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private Integer status;
	
	@Getter
	@Setter
	private Integer type;
	
	@Getter
	@Setter
	private Integer isNew;
	
	@Getter
	@Setter
	private String deployDate;
	
	@Getter
	@Setter
	private String deployTime;
	
	@Getter
	@Setter
	private Integer isChangeSql;
	
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
