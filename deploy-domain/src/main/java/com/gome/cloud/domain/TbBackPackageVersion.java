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
public class TbBackPackageVersion {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	@Getter
	@Setter
	private String packageVersionNo;
	
	@Getter
	@Setter
	private String createUser;
	@Getter
	@Setter
	private Date createTime;
	
	@Getter
	@Setter
	private String UUID;
	
	
	
}
