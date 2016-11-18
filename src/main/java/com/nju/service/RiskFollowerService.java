package com.nju.service;

import java.util.List;
import java.util.Map;

import com.nju.data.dataobject.RiskDO;
import com.nju.data.dataobject.RiskFollowerDO;

public interface RiskFollowerService {
	public int getMaxId() ;
	public void followRisk(RiskFollowerDO followerRisk) ;
	public List<RiskFollowerDO> getFollowedRiskByUId(int uid) ;
	
}
