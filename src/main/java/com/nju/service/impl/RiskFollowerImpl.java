package com.nju.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nju.data.dao.RiskFollowerDODAO;
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.service.RiskFollowerService;
@Service
public class RiskFollowerImpl implements RiskFollowerService{
	private RiskFollowerDODAO riskFollowerDao ;
	@Override
	public void followRisk(RiskFollowerDO riskFollower) {
		// TODO Auto-generated method stub
		riskFollowerDao.save(riskFollower) ;
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		List riskFollowers = riskFollowerDao.findAll();
		if(riskFollowers!=null && !riskFollowers.isEmpty()){
			return riskFollowers.size() ;
		}
		return 0 ;
	}
}
