package com.nju.data;

import com.nju.model.Course;
import com.nju.model.Risk;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface DataService {

	
	List<Course> getCourses(int studentId) throws RemoteException;




    Map<String, List<Course>> getOtherCourses(int studentId) throws RemoteException;

    List<Course> getMyCourses(int studentId) throws RemoteException;

    boolean chooseCourse(int studentId, int courseId, String department) throws RemoteException;

    boolean dropCourse(int studentId, int courseId, String department) throws RemoteException;
	
	
	
}
