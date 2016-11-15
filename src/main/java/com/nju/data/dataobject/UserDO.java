package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * UserDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="user"
    ,catalog="fxpgxt"
)

public class UserDO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String password;


    // Constructors

    /** default constructor */
    public UserDO() {
    }

	/** minimal constructor */
    public UserDO(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public UserDO(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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
    
    @Column(name="password", length=45)

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}