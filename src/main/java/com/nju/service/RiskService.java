package com.nju.service;



import com.nju.model.Risk;

import java.util.List;


public interface RiskService {
    List<Risk> getAllRisks();
    void addRisk(Risk risk);
    Risk getRisk(int risk_id);
    void deleteRisk(int risk_id);
}
