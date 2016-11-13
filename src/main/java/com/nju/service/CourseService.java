package com.nju.service;

import com.nju.model.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/6/5.
 */
public interface CourseService {
    List<Course> getCourses(int studentId);

    Map<String, List<Course>> getOtherCourses(int studentId);

    List<Course> getMyCourses(int studentId);

    boolean chooseCourse(int studentId, int courseId, String department);

    boolean dropCourse(int studentId, int courseId, String department);
}
