package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * PlanDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="plan"
    ,catalog="fxpgxt"
)

public class PlanDO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;


    // Constructors

    /** default constructor */
    public PlanDO() {
    }

	/** minimal constructor */
    public PlanDO(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public PlanDO(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    
    @Column(name="name", length=45)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}