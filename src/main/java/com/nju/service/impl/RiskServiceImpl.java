package com.nju.service.impl;


import com.nju.data.dao.RiskDODAO;
import com.nju.data.dataobject.RiskDO;
import com.nju.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskServiceImpl implements RiskService{
    @Autowired
    private RiskDODAO riskDao;

    @Override
    public List getAllRisks(){
        return riskDao.findAll() ;
    }

    @Override
    public void addRisk(RiskDO risk){
        riskDao.save(risk) ;
    }

    @Override
    public RiskDO getRisk(int  risk_id){
        return riskDao.findById(risk_id) ;
    }

    @Override
    public void deleteRisk(int risk_id){
        RiskDO risk = riskDao.findById(risk_id) ;
        if(risk!=null){
        	riskDao.delete(risk) ;
        }
    }

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
	
		List risks = riskDao.findAll() ;
		if(risks!=null && !risks.isEmpty()){
			return risks.size() ;
		}
		return 0 ;
	}

	


}
