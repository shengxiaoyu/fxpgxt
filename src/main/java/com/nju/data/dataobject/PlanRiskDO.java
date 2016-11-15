package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * PlanRiskDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="plan_risk"
    ,catalog="fxpgxt"
)

public class PlanRiskDO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer PId;
     private Integer RId;


    // Constructors

    /** default constructor */
    public PlanRiskDO() {
    }

	/** minimal constructor */
    public PlanRiskDO(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public PlanRiskDO(Integer id, Integer PId, Integer RId) {
        this.id = id;
        this.PId = PId;
        this.RId = RId;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="p_id")

    public Integer getPId() {
        return this.PId;
    }
    
    public void setPId(Integer PId) {
        this.PId = PId;
    }
    
    @Column(name="r_id")

    public Integer getRId() {
        return this.RId;
    }
    
    public void setRId(Integer RId) {
        this.RId = RId;
    }
   








}