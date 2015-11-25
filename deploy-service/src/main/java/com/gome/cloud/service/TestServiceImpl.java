/**
 * 
 */
package com.gome.cloud.service;

import javax.annotation.Resource;

import com.gome.cloud.dao.TestDao;

/**
 * @author blaiu
 *
 */
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	
	@Override
	public void test() {
		testDao.test();
	}

//	public void setTestDao(TestDao testDao) {
//		this.testDao = testDao;
//	}
//	
	

}
