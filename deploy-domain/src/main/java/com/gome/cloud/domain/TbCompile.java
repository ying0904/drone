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
public class TbCompile {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	
	@Getter
	@Setter
	private String trunk;
	@Getter
	@Setter
	private Integer testType;
	@Getter
	@Setter
	private Integer onlineType;
	
	@Getter
	@Setter
	private Integer status;
	
	@Getter
	@Setter
	private String testUser;
	@Getter
	@Setter
	private String testEmail;
	
	@Getter
	@Setter
	private String remark;
	
	@Getter
	@Setter
	private String createUser;
	@Getter
	@Setter
	private Date createTime;
	
	
	
}
