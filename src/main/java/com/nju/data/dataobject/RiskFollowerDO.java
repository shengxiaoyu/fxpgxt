package com.nju.data.dataobject;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


/**
 * RiskFollowerDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="risk_follower"
    ,catalog="fxpgxt"
)

public class RiskFollowerDO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer RId;
     private Integer UId;
     private String possibility;
     private String influence;
     private String gate;
     private Date beginTime;
     private Date endTime;
     private String description;


    // Constructors

    /** default constructor */
    public RiskFollowerDO() {
    }

    
    /** full constructor */
    public RiskFollowerDO(Integer RId, Integer UId, String possibility, String influence, String gate, Date beginTime, Date endTime, String description) {
        this.RId = RId;
        this.UId = UId;
        this.possibility = possibility;
        this.influence = influence;
        this.gate = gate;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.description = description;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="com.nju.data.dataobject")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="r_id")

    public Integer getRId() {
        return this.RId;
    }
    
    public void setRId(Integer RId) {
        this.RId = RId;
    }
    
    @Column(name="u_id")

    public Integer getUId() {
        return this.UId;
    }
    
    public void setUId(Integer UId) {
        this.UId = UId;
    }
    
    @Column(name="possibility", length=45)

    public String getPossibility() {
        return this.possibility;
    }
    
    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }
    
    @Column(name="influence", length=45)

    public String getInfluence() {
        return this.influence;
    }
    
    public void setInfluence(String influence) {
        this.influence = influence;
    }
    
    @Column(name="gate", length=45)

    public String getGate() {
        return this.gate;
    }
    
    public void setGate(String gate) {
        this.gate = gate;
    }
    
  
    @Temporal(TemporalType.DATE)
    @Column(name="begin_time", length=10)

    public Date getBeginTime() {
        return this.beginTime;
    }
    
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="end_time", length=10)

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    @Column(name="description", length=65535)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}