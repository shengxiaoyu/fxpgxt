package com.nju.model;

public class Student {

	
	private int studentId;
	private String studentName;
	private char studentSex;
	private String studentDepartment;
	private String password;
	
	
	public Student(){}
	public Student(int id,String name,char sex,String dept,String pwd){
		this.studentId = id;
		this.studentName = name;
		this.studentSex = sex;
		this.studentDepartment = dept;
		this.password = pwd;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public char getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(char studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
