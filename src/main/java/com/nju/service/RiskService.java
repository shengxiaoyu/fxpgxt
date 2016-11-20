package com.nju.service;





import java.util.List;
import java.util.Map;

import com.nju.data.dataobject.RiskDO;
import com.nju.service.model.ChartDataModel;


public interface RiskService {
    public List<RiskDO> getAllRisks();
    public RiskDO getRisk(int risk_id);
    public void deleteRisk(int risk_id);
    public int getMaxId() ;
	public void addRisk(RiskDO risk);
	public Map<Integer,Integer> getRecognizedTimes(String begin,String end) ;
	public Map<Integer,Integer> getComeTrueTimes(String begin,String end) ;
	public List<ChartDataModel> getChartData(String begin,String end) ;
}
