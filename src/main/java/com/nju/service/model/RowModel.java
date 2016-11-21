package com.nju.service.model;

public class RowModel {
	private int riskId ;
	private String riskName ;
	private int time ;
	public RowModel(int id,String key,int value){
		this.riskId = id ;
		this.riskName = key ;
		this.time = value ;
	}
	public int getRiskId() {
		return riskId;
	}
	public void setRiskId(int riskId) {
		this.riskId = riskId;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
