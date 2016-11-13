package com.nju.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	public String getStudentPass(String username){
		return "1234" ;
	}
}
