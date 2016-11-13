package com.nju.model;


public class Course {

	
	private int courseId;
	 private String courseName;
	 private int courseTime;
	 private int coursePoint;
	 private String teacherName;
	 private String coursePlace;
	 private int isShared;
	 
	
	 
	 public Course(int id,String name,int point,String teacher,String place,int share,int time){
		 this.courseId = id;
		 this.courseName = name;
		 this.courseTime = time;
		 this.coursePoint = point;
		 this.teacherName = teacher;
		 this.coursePlace = place;
		 this.isShared = share;
	 }
	 
	 public Course(){}
	 
	 public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}
	public int getCoursePoint() {
		return coursePoint;
	}
	public void setCoursePoint(int coursePoint) {
		this.coursePoint = coursePoint;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	public void setCoursePlace(String coursePlace) {
		this.coursePlace = coursePlace;
	}
	
	


	public int getIsShared() {
		return isShared;
	}

	public void setIsShared(int isShared) {
		this.isShared = isShared;
	}

	 
}
