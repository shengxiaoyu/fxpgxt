package com.nju.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nju.data.dao.PlanDODAO;
import com.nju.data.dao.PlanRiskDODAO;
import com.nju.data.dao.RiskDODAO;
import com.nju.data.dao.RiskFollowerDODAO;
import com.nju.data.dataobject.PlanDO;
import com.nju.data.dataobject.PlanRiskDO;
import com.nju.data.dataobject.RiskDO;
import com.nju.service.PlanService;
@Controller
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanDODAO planDao ;
	@Autowired
	private RiskFollowerDODAO followerDao ;
	@Autowired
	private PlanRiskDODAO planRiskDao ;
	@Autowired
	private RiskDODAO riskDao ;
	@Override
	public boolean addPlan(PlanDO plan) {
		// TODO Auto-generated method stub
		planDao.save(plan) ;
		return true ;
	}

	@Override
	public void addRiskIntoPlan(PlanDO plan, RiskDO risk) {
		// TODO Auto-generated method stub
		PlanRiskDO planRisk = new PlanRiskDO() ;
		List<PlanRiskDO> list = planRiskDao.findAll() ;
		if(list!=null&&!list.isEmpty()){
			planRisk.setId(list.size()) ;
		}else
			planRisk.setId(0) ;
		planRisk.setPId(plan.getId()) ;
		planRisk.setRId(risk.getId()) ;
		planRiskDao.save(planRisk) ;
	}

	@Override
	public void addRisksIntoPlan(PlanDO plan, List<RiskDO> risks) {
		// TODO Auto-generated method stub
		for(RiskDO risk:risks){
			this.addRiskIntoPlan(plan, risk) ;
		}
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		List<PlanDO> list = planDao.findAll() ;
		if(list!=null &&!list.isEmpty()){
			return list.size() ;
		}
		return 0 ;
	}

	@Override
	public List<PlanDO> getAllPlans() {
		// TODO Auto-generated method stub
		return planDao.findAll() ;
	}

	@Override
	public List<RiskDO> getPlanDetail(int pid) {
		// TODO Auto-generated method stub
		List<RiskDO> result = new ArrayList<RiskDO>() ;
		List<PlanRiskDO> planRisks = (List<PlanRiskDO>) planRiskDao.findByPId(pid);
		for(PlanRiskDO planRisk:planRisks){
			result.add(riskDao.findById(planRisk.getRId())) ;
		}
		return result ;
	}

}
