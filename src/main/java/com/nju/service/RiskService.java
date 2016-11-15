package com.nju.service;





import java.util.List;

import com.nju.data.dataobject.RiskDO;
import com.nju.data.dataobject.RiskFollowerDO;


public interface RiskService {
    List<RiskDO> getAllRisks();
    RiskDO getRisk(int risk_id);
    void deleteRisk(int risk_id);
    int getMaxId() ;
	void addRisk(RiskDO risk);
	
}
