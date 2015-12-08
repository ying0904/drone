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
public class TbObject {

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String projectId;
	
	@Getter
	@Setter
	private String projectChineseName;
	
	@Getter
	@Setter
	private Integer projectLevel;
	
	@Getter
	@Setter
	private String projectChief;
	
	@Getter
	@Setter
	private String department;

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
	private String remark;
	@Getter
	@Setter
	private Integer isDel;
	
}
