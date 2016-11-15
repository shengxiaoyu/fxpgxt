package com.nju.service;

import com.nju.data.dataobject.RiskFollowerDO;

public interface RiskFollowerService {
	public int getMaxId() ;
	void followRisk(RiskFollowerDO followerRisk) ;
}
