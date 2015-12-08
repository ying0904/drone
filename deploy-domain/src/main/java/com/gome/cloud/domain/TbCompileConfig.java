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
public class TbCompileConfig {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String appId;
	
	@Getter
	@Setter
	private String profileIdTest;
	@Getter
	@Setter
	private String profileIdProduct;
	@Getter
	@Setter
	private Integer profilePath;
	
	@Getter
	@Setter
	private String createUser;
	@Getter
	@Setter
	private Date createTime;
	
	
	
}
