package com.nju.service.impl;

import com.nju.data.StudentDao;
import com.nju.model.Student;
import com.nju.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao ;

    @Override
    public String getStudentPass(String username) {
       return studentDao.getStudentPass(username);
    }

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
