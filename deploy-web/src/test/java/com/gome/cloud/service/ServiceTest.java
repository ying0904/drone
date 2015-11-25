package com.gome.cloud.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/spring/spring-config.xml", "classpath*:spring/spring-mvc.xml", "classpath*:mybatis/mybatis-config-mysql.xml"})
public class ServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private TestService testService;
	
	@Test
	public void queryTest () {
		testService.test();
	}
	
}
