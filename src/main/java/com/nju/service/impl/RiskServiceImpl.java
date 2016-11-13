package com.nju.service.impl;

import com.nju.data.RiskDao;
import com.nju.model.Risk;
import com.nju.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskServiceImpl implements RiskService{
    @Autowired
    private RiskDao riskDao;

    @Override
    public List<Risk> getAllRisks(){
        return riskDao.getAllRisks();
    }

    @Override
    public void addRisk(Risk risk){
        riskDao.addRisk(risk);
    }

    @Override
    public Risk getRisk(int  risk_id){
        return riskDao.getRisk(risk_id);
    }

    @Override
    public void deleteRisk(int risk_id){
        riskDao.deleteRisk(risk_id);
    }
}
