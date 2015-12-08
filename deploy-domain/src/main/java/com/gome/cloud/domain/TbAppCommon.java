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
public class TbAppCommon {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	
	@Getter
	@Setter
	private String fileName;
	@Getter
	@Setter
	private String filePath;
	
	@Getter
	@Setter
	private String createUser;
	@Getter
	@Setter
	private Date createTime;
	
	
	
}
