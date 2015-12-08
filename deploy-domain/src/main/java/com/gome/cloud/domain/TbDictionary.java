/**
 * 
 */
package com.gome.cloud.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author blaiu
 *
 */
public class TbDictionary {

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private Integer type;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String key;
	
	@Getter
	@Setter
	private String value;
	
	@Getter
	@Setter
	private String createUser;
	@Getter
	@Setter
	private String createTime;
	@Getter
	@Setter
	private String updateUser;
	@Getter
	@Setter
	private String updateTime;
	
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private Integer isDel;
}
