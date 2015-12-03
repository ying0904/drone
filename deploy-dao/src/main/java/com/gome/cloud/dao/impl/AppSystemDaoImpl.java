package com.gome.cloud.dao.impl;
import java.util.List;

import com.gome.cloud.dao.AppSystemDao;
import com.gome.cloud.dao.BaseDao;
import com.gome.cloud.domain.TbAppSystem;


public class AppSystemDaoImpl extends BaseDao implements AppSystemDao {

	private String getNamespace() {
		return "AppSystemMapper.";
	}
	
	@Override
	public List<TbAppSystem> addAppSystem(List<TbAppSystem> list) {
		getSqlSession().insert(getNamespace() + "addAppSystem", list);
		return list;
	}

}
