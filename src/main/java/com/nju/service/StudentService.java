package com.nju.service;

import com.nju.model.Student;

import java.util.List;



public interface StudentService {
    List<Student> getAllStudents();
    public String getStudentPass(String id);
}
