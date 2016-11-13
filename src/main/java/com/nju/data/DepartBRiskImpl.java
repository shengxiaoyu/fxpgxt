package com.nju.data;

import com.nju.model.Course;
import com.nju.model.Risk;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zongyi on 2016/11/10.
 */
public class DepartBRiskImpl implements RiskService{
    Connection conn = null;
    Statement stmt = null;
    RequireService req = null;


    public DepartBRiskImpl(){

        try {

            String url = "jdbc:mysql://localhost:3306/YYJC_Depart_B?"
                    + "&useUnicode=true&characterEncoding=UTF8";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "Zy502600129");
            stmt = conn.createStatement();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Risk> getAllRisks() {
        List<Risk> res = new ArrayList<Risk>();
        //res.addAll(req.getMyOtherCourses(studentId));
        String sql = "select * from risk ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){


                int riskId = rs.getInt(1);
                String riskName = rs.getString(2);
                String riskContent = rs.getString(3);
                String riskLevel = rs.getString(4);
                String riskPossibility = rs.getString(5);
                String riskGate = rs.getString(6);
                String riskCreator = rs.getString(7);
                String riskFollower = rs.getString(8);
                String riskCreatedTime = rs.getString(9);

                Risk r = new Risk(riskId, riskName, riskContent, riskLevel, riskPossibility, riskGate, riskCreator,riskFollower,riskCreatedTime);

                res.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;

    }


    public void addRisk(Risk risk) {

        //res.addAll(req.getMyOtherCourses(studentId));
        String sql = "insert into risk values (0,'"+risk.getRiskName()+"','"+risk.getRiskContent()+"','"+risk.getRiskLevel()+"','"+risk.getRiskPossibility()+"','" +
                risk.getRiskGate()+"','"+risk.getRiskCreator()+"','"+risk.getRiskFollower()+"','"+risk.getRiskCreatedTime()+"')";

        try {
            boolean rs = stmt.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public Risk getRisk(int risk_id) {
        String sql = "select * from risk where risk_id = "+ risk_id ;
        try {

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int riskId = rs.getInt(1);
                String riskName = rs.getString(2);
                String riskContent = rs.getString(3);
                String riskLevel = rs.getString(4);
                String riskPossibility = rs.getString(5);
                String riskGate = rs.getString(6);
                String riskCreator = rs.getString(7);
                String riskFollower = rs.getString(8);
                String riskCreatedTime = rs.getString(9);

                Risk r = new Risk(riskId, riskName, riskContent, riskLevel, riskPossibility, riskGate, riskCreator, riskFollower, riskCreatedTime);
                return r;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void deleteRisk(int  risk_id) {

        //res.addAll(req.getMyOtherCourses(studentId));
        String sql = "delete  from risk where risk_id = "+ risk_id ;
        try {
            boolean rs = stmt.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public void followRisk(int risk_id,String follower_id){
        String sql = "select * from risk where risk_id = "+ risk_id ;

        try {

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int riskId = rs.getInt(1);
                String riskName = rs.getString(2);
                String riskContent = rs.getString(3);
                String riskLevel = rs.getString(4);
                String riskPossibility = rs.getString(5);
                String riskGate = rs.getString(6);
                String riskCreator = rs.getString(7);
                String riskFollower = rs.getString(8);
                String riskCreatedTime = rs.getString(9);

                Risk r = new Risk(riskId, riskName, riskContent, riskLevel, riskPossibility, riskGate, riskCreator, riskFollower, riskCreatedTime);
                r.setRiskFollower(r.getRiskFollower() +  follower_id+";") ;
                Statement stmt2 = conn.createStatement();
                String sql_update = " UPDATE risk SET risk_follower = '" + r.getRiskFollower() + "' WHERE risk_id = " +risk_id ;
                System.out.println(sql_update);
                boolean rs_update = stmt2.execute(sql_update);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
