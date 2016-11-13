package com.nju.data;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CenterService extends Remote{
	

	public String AgetBSharedCourse(int studentId) throws RemoteException;
	public String AgetCSharedCourse(int studentId) throws RemoteException;
	
	public String BgetASharedCourse(int studentId) throws RemoteException;
	public String BgetCSharedCourse(int studentId) throws RemoteException;
	
	public String CgetASharedCourse(int studentId) throws RemoteException;
	public String CgetBSharedCourse(int studentId) throws RemoteException;
	
	
	public boolean chooseACourse(int studentId, int courseId) throws RemoteException;
	public boolean chooseBCourse(int studentId, int courseId) throws RemoteException;
	public boolean chooseCCourse(int studentId, int courseId) throws RemoteException;
	
	public boolean dropACourse(int studentId, int courseId) throws RemoteException;
	public boolean dropBCourse(int studentId, int courseId) throws RemoteException;
	public boolean dropCCourse(int studentId, int courseId) throws RemoteException;
	
	
	
}
