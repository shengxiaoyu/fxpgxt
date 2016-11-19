package com.nju.service.impl;


import com.nju.data.dao.RiskDODAO;
import com.nju.data.dao.RiskFollowerDODAO;
import com.nju.data.dataobject.RiskDO;
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.service.RiskService;
import com.nju.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiskServiceImpl implements RiskService{
    @Autowired
    private RiskDODAO riskDao;
    @Autowired
    private RiskFollowerDODAO followerDao;
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
	
		return riskDao.getMaxId() ;
	}

	@Override
	public Map<Integer, Integer> getRecognizedTimes(String begin, String end) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<Integer, Integer>() ;
		List<RiskFollowerDO> list = followerDao.getRecognizedRisks(begin,end) ;
		for(RiskFollowerDO riskFollowed:list){
			int riskId = riskFollowed.getRId() ;
			if(map.get(riskId)!=null){
				map.put(riskId, map.get(riskId)+1) ;
			}else{
				map.put(riskId, 1) ;
			}
		}
		return map ;
	}

	@Override
	public Map<Integer, Integer> getComeTrueTimes(String begin, String end) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<Integer, Integer>() ;
		List<RiskFollowerDO> list = followerDao.getComeTrueRisks(begin,end) ;
		for(RiskFollowerDO riskFollowed:list){
			int riskId = riskFollowed.getRId() ;
			if(map.get(riskId)!=null){
				map.put(riskId, map.get(riskId)+1) ;
			}else{
				map.put(riskId, 1) ;
			}
		}
		return map ;
	}

	


}
