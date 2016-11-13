package com.nju.data;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProvideService extends Remote{
	public String getCourse(int studentId) throws RemoteException;
	public boolean chooseCourse(int studentId, int courseId) throws RemoteException;
	public boolean dropCourse(int studentId, int courseId) throws RemoteException;

}
