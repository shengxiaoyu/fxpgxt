package com.nju.data;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.nju.model.Student;

@Repository
public class StudentDao {
	private static ArrayList<Student> list = new ArrayList<Student>() ;
	static {
		Student s1 = new Student(1, "testOne", 'M', "", "1234") ;
		Student s2 = new Student(1, "testOne", 'F', "", "1234") ;
		list.add(s1) ;
		list.add(s2) ;
		
	}
	public String getStudentPass(String username){
		for(Student s:list){
			if(s.getStudentName().equals(username)){
				return s.getPassword() ;
			}
		}
		return null ;
	}
}
