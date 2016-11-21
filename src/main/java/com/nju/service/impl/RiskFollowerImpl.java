package com.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.data.dao.RiskFollowerDODAO;
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.service.RiskFollowerService;
@Service
public class RiskFollowerImpl implements RiskFollowerService{
	@Autowired
	private RiskFollowerDODAO riskFollowerDao ;
	@Override
	public void followRisk(RiskFollowerDO riskFollower) {
		// TODO Auto-generated method stub
		riskFollowerDao.update(riskFollower) ;
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		
		return riskFollowerDao.getMaxId();
	}

	@Override
	public List<RiskFollowerDO> getFollowedRiskByUId(int uid) {
		// TODO Auto-generated method stub
		return riskFollowerDao.findByUId(new Integer(uid));
	}

	@Override
	public void assignRisk(RiskFollowerDO riskFollower) {
		// TODO Auto-generated method stub
		riskFollowerDao.save(riskFollower) ;
	}
}
