package com.nju.service.impl;

import com.nju.data.DepartBDataImpl;
import com.nju.model.Student;
import com.nju.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 传旺 on 2016/6/6.
 */
@Service
public class StudentServiceImpl implements StudentService {
//	private StudentD
    @Override
    public List<Student> getAllStudents() {
        com.nju.data.StudentService studentService = new DepartBDataImpl();
        return studentService.getAllStudents();
    }

    @Override
    public String getStudentPass(String username) {
        com.nju.data.StudentService studentService = new DepartBDataImpl();
        return studentService.getStudentPass(username);
    }
}
