package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.PlanDO;
import com.nju.data.dataobject.RiskDO;

public interface PlanService {
	public boolean addPlan(PlanDO plan) ;
	public void addRiskIntoPlan(PlanDO plan,RiskDO risk) ;
	public void addRisksIntoPlan(PlanDO plan,List<RiskDO> risks) ;
	public int getMaxId() ;
	public List<PlanDO> getAllPlans() ;
	public List<RiskDO> getPlanDetail(int pid) ;
}
