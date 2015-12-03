/**
 * 
 */
package com.gome.cloud.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gome.cloud.domain.TbAppSystem;
import com.gome.cloud.service.AppSystemService;
import com.gome.cloud.utils.jackson.JacksonUtil;


/**
 * @author blaiu
 *
 */
@Controller("appSystemController")
@RequestMapping("/app/system")
public class AppSystemController {

	@Resource
	private AppSystemService appSystemService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String add(String json) {
		List<TbAppSystem> list = JacksonUtil.readValue(json, new TypeReference<List<TbAppSystem>>(){});
		list = appSystemService.addAppSystem(list);
		return JacksonUtil.toJSon(list);
	}
	
}
