package com.nju.dao;

import com.nju.model.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 传旺 on 2016/6/12.
 */
@Repository
public class CourseDao {

    public CourseDao(){
//        try {
//
//            String url = "jdbc:mysql://localhost:3306/YYJC_Depart_B?"
//                    + "&useUnicode=true&characterEncoding=UTF8";
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url, "root", "Zy502600129");
//            stmt = conn.createStatement();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    Connection conn = null;
    Statement stmt = null;

    public List<Course> getCourse(int studentId) {
        List<Course> res = new ArrayList<Course>();
        String sql = "select 课程编号 from choosecourse where 学号 = "+studentId;
        String sql2 = "select * from course";
        ArrayList<Integer> coursechoose = new ArrayList<Integer>();
        try {
            ResultSet rs1 = stmt.executeQuery(sql);
            while(rs1.next()){
                int id = rs1.getInt(1);
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

}
