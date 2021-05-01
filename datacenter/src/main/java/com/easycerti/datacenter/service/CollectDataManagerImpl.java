package com.easycerti.datacenter.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easycerti.datacenter.dao.CollectDataDAO;

@Service( "CollectDataManager" )
public class CollectDataManagerImpl implements CollectDataManager {
	
	@Autowired
	 private CollectDataDAO collectDataDAO;
	
	@Override
	public List<Map<String, Object>> selectCollectDataCheck(){
		return collectDataDAO.selectCollectDataCheck();
	}
//	public String selectCollectDataCheck(){
//		return collectDataDAO.selectCollectDataCheck();
//	}
}
