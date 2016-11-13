package com.nju.data;

import java.util.List;

import com.nju.model.Student;

	public interface StudentService {
	   	public List<Student> getAllStudents();

		public String getStudentPass(String id);
	}

