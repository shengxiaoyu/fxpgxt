package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * RiskDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="risk"
    ,catalog="fxpgxt"
)

public class RiskDO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String content;
     private String creator;


    // Constructors

    /** default constructor */
    public RiskDO() {
    }

	/** minimal constructor */
    public RiskDO(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public RiskDO(Integer id, String name, String content, String creator) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.creator = creator;
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
    
    @Column(name="content", length=45)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="creator", length=45)

    public String getCreator() {
        return this.creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
   








}