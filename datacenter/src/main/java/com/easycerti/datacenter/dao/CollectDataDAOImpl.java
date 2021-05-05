package com.easycerti.datacenter.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository( "CollectDataDAO" )
public class CollectDataDAOImpl implements CollectDataDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE_CODE = "com.easycerti.datacenter.collectdata_mapper";
	
	@Override
	public List<Map<String, Object>> selectCollectDataCheck(){
		return sqlSession.selectList(NAMESPACE_CODE + ".selectCollectDataCheck");
	}
	
}
