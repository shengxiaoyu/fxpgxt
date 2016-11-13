package com.nju.service.impl;

import com.nju.dao.CourseDao;
import com.nju.dao.TestDao;
import com.nju.data.DataService;
import com.nju.data.DepartBDataImpl;
import com.nju.model.Course;
import com.nju.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/6/5.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private TestDao testDao;
    @Autowired
    private CourseDao courseDao;

    /**
     * 获得本院系A的课程，包含学生是否选择某门课程的信息
     * @param studentId 学生id
     * @return 返回一个课程列表List、ArrayList
     */
    @Override
    public List<Course> getCourses(int studentId) {
        return courseDao.getCourse(studentId);
    }

    /**
     * 获得其他院系的课程，包含学生是否选择某门课程的信息
     * @param studentId 学生id
     * @return 返回map，String：院系名称，Object：课程列表
     */
    @Override
    public Map<String, List<Course>> getOtherCourses(int studentId) {
        DataService service = new DepartBDataImpl();
        HashMap<String, List<Course>> result = null;
        try {
             result = (HashMap<String, List<Course>>) service.getOtherCourses(studentId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获得我选的课程
     * @return 返回选课的列表List、ArrayList
     */
    @Override
    public List<Course> getMyCourses(int studentId) {
        DataService service = new DepartBDataImpl();
        try {
            return service.getMyCourses(studentId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 选课
     * @param studentId 学生id
     * @param courseId 课程id
     * @param department 院系：A、B、C
     * @return
     */
    @Override
    public boolean chooseCourse(int studentId, int courseId, String department) {
        DataService service = new DepartBDataImpl();
        try {
            return service.chooseCourse(studentId,courseId,department);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 退课
     * @param studentId 学生id
     * @param courseId 课程id
     * @param department 院系：A、B、C
     * @return
     */
    @Override
    public boolean dropCourse(int studentId, int courseId, String department) {
        DataService service = new DepartBDataImpl();
        try {
            return service.dropCourse(studentId,courseId,department);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
