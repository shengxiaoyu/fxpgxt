package com.nju.service;



import com.nju.model.Risk;

import java.util.List;

/**
 * Created by Zongyi on 2016/11/10.
 */
public interface RiskService {
    List<Risk> getAllRisks();
    void addRisk(Risk risk);
    Risk getRisk(int risk_id);
    void deleteRisk(int risk_id);
}
