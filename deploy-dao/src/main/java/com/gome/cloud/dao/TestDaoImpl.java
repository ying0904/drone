/**
 * 
 */
package com.gome.cloud.dao;

/**
 * @author blaiu
 *
 */
public class TestDaoImpl extends BaseDao implements TestDao {

	@Override
	public void test() {
		getSqlSession().selectList("AppMapper.queryApp");
	}

}
