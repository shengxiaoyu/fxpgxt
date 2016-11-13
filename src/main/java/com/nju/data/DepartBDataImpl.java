package com.nju.data;

import com.nju.model.Course;
import com.nju.model.Student;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartBDataImpl implements DataService,StudentService {
	Connection conn = null;
	Statement stmt = null;
	RequireService req = null;

	
	public DepartBDataImpl(){
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/YYJC_Depart_B?"
					+ "&useUnicode=true&characterEncoding=UTF8";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "Zy502600129");
			stmt = conn.createStatement();
			//req = new DepartBRequireImpl();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	 /**
     * 获得本院系A的课程，包含学生是否选择某门课程的信息
     * @param studentId 学生id
     * @return 返回一个课程列表List、ArrayList
     */
    @Override
    public List<Course> getCourses(int studentId) {
    	List<Course> res = new ArrayList<Course>();
    	String sql = "select 课程编号 from choosecourse where 学号 = "+studentId;
    	String sql2 = "select * from course";
    	ArrayList<Integer> coursechoose = new ArrayList<Integer>();
    	try {
			ResultSet rs1 = stmt.executeQuery(sql);
			while(rs1.next()){
				int id = rs1.getInt(2);
				coursechoose.add(id);
			}
			ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int time = rs.getInt(3);
				int point = rs.getInt(4);
				
				String teacher = rs.getString(5);
				String place = rs.getString(6);
				int share = rs.getInt(7);
				
				Course c = new Course(id, name, point, teacher, place, share, time);
				if(coursechoose.contains(id)){c.setIsShared(2);}
				res.add(c);
			}
			return res;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    /**
     * 获得其他院系的课程，包含学生是否选择某门课程的信息
     * @param studentId 学生id
     * @return 返回map，String：院系名称，Object：课程列表
     */
    @Override
    public Map<String, List<Course>> getOtherCourses(int studentId) throws RemoteException{
    	return null;
        
    }

    /**
     * 获得我选的课程
     * @return 返回选课的列表List、ArrayList
     */
    @Override
    public List<Course> getMyCourses(int studentId) throws RemoteException{
    	List<Course> res = new ArrayList<Course>();
    	//res.addAll(req.getMyOtherCourses(studentId));
    	String sql = "select course.* from course,choosecourse where course.编号 = chooseCourse.课程编号 and chooseCourse.学号 ="+studentId;
    	try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int time = rs.getInt(3);
				int point = rs.getInt(4);		
				String teacher = rs.getString(5);
				String place = rs.getString(6);
				int share = rs.getInt(7);
				Course c = new Course(id, name, point, teacher, place, share, time);
				c.setIsShared(2);
				res.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return res;
    }

    /**
     * 选课
     * @param studentId 学生id
     * @param courseId 课程id
     * @param department 院系：A、B、C
     * @return
     */
    @Override
    public boolean chooseCourse(int studentId, int courseId, String department) throws RemoteException{
    	if(department.equals("B")){
    		String sql = "insert into choosecourse values ("+courseId+","+studentId+",0)";
    		try {
				int state = stmt.executeUpdate(sql);
				if(state>0)return true;
				else return false;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
    	}else{
    		return false;
    	}
    }

    /**
     * 退课
     * @param studentId 学生id
     * @param courseId 课程id
     * @param department 院系：A、B、C
     * @return
     */
    @Override
    public boolean dropCourse(int studentId, int courseId, String department) throws RemoteException{
    	if(department.equals("B")){
    		String sql = "delete from choosecourse where 课程编号 = "+courseId+" and 学号 = "+studentId;
    		try {
				int state = stmt.executeUpdate(sql);
				if(state>0)return true;
				else return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
    	}else{
    		return false;
    	}
        
    }
    
    @Override
 	public List<Student> getAllStudents() {
     	List<Student> res = new ArrayList<Student>();
     	String sql = "select * from student";
     	try {
 			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next()){
 				int id = rs.getInt(1);
 				String name = rs.getString(2);
 				char sex = rs.getString(3).charAt(0);
 				String depart = rs.getString(4);
 				String pwd = rs.getString(5);
 				Student c = new Student(id, name, sex, depart, pwd);
 				res.add(c);
 			}
 			return res;
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         return null;
 	}

	@Override
	public String getStudentPass(String id) {
		return "123456";
	}

}