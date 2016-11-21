package com.nju.service.model;

public class ChartDataModel {
	private String riskName ;
	private int time1 ;
	private int time2 ;
	
	public ChartDataModel(String riskName, int time1, int time2) {
		super();
		this.riskName = riskName;
		this.time1 = time1;
		this.time2 = time2;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public int getTime1() {
		return time1;
	}
	public void setTime1(int time1) {
		this.time1 = time1;
	}
	public int getTime2() {
		return time2;
	}
	public void setTime2(int time2) {
		this.time2 = time2;
	}
	
}
