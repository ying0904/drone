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
public class TbAppResources {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	
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
	private Integer isDel;
	
	
	
}
