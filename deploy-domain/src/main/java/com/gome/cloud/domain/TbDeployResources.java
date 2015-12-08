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
public class TbDeployResources {

	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String deployId;
	@Getter
	@Setter
	private String deployIp;
	
	@Getter
	@Setter
	private String UUID;
	
}
