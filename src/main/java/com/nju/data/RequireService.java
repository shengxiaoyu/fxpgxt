package com.nju.data;

import com.nju.model.Course;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface RequireService {

	public Map<String, List<Course>> getOtherCourses(int studentId) throws RemoteException;
	public List<Course> getMyOtherCourses(int studentId) throws RemoteException;
	public boolean chooseOtherCourse(int studentId, int courseId, String department) throws RemoteException;
	public boolean dropOtherCourse(int studentId, int courseId, String department) throws RemoteException;
}
