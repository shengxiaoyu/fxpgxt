package com.nju.service.model;

import java.util.Date;

import com.nju.data.dataobject.RiskDO;
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.data.dataobject.UserDO;

public class RiskFollowerModel {
	private int id ;
	private int risk_id ;
	private String risk_name ;
	private String risk_content ;
	private String risk_po ;
	private String risk_inf ;
	private String gate ;
	private String follower ;
	private Date begin ;
	private Date end ;
	private String description;
	public RiskFollowerModel(int id, int risk_id,String risk_name, String risk_content,
			String risk_po, String risk_inf, String follower, String gate,
			Date begin, Date end,String description ) {
		super();
		this.id = id;
		this.risk_id = risk_id ;
		this.risk_name = risk_name;
		this.risk_content = risk_content;
		this.risk_po = risk_po;
		this.risk_inf = risk_inf;
		this.follower = follower;
		this.gate = gate;
		this.begin = begin;
		this.end = end;
		this.description = description ;
	}
	public RiskFollowerModel(RiskDO risk,RiskFollowerDO follower,UserDO user){
		this(follower.getId(),risk.getId(),risk.getName(),risk.getContent(),follower.getPossibility(),follower.getInfluence(),user.getName(),follower.getGate(),follower.getBeginTime(),follower.getEndTime(),follower.getDescription()) ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRisk_name() {
		return risk_name;
	}
	public void setRisk_name(String risk_name) {
		this.risk_name = risk_name;
	}
	public String getRisk_content() {
		return risk_content;
	}
	public void setRisk_content(String risk_content) {
		this.risk_content = risk_content;
	}
	public String getRisk_po() {
		return risk_po;
	}
	public void setRisk_po(String risk_po) {
		this.risk_po = risk_po;
	}
	public String getRisk_inf() {
		return risk_inf;
	}
	public void setRisk_inf(String risk_inf) {
		this.risk_inf = risk_inf;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRisk_id() {
		return risk_id;
	}
	public void setRisk_id(int risk_id) {
		this.risk_id = risk_id;
	}
	
}
