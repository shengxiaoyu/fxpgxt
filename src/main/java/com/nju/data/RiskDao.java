package com.nju.data;

import com.nju.model.Risk;
import com.nju.model.Student;

import org.springframework.stereotype.Repository;

import util.IOHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



@Repository
public class RiskDao {
	private static ArrayList<Risk> list = new ArrayList<Risk>() ;
	
    static {
    	Risk r1 = new Risk(1, "riskName", "riskContent", "riskLevel", "riskPossibility", "riskGate", "riskCreator", "riskFollower", "riskCreatedTime") ;
    	Risk r2 = new Risk(2, "risk1", "test1", "high", "high", "50%", "root", "root", "2016/11/10") ;
    	Risk r3 = new Risk(3, "risk2", "test3", "low", "low", "70%", "test", "test", "2016/11/11") ;
		list.add(r1) ;
		list.add(r2) ;
		list.add(r3) ;
//		IOHelper.saveObject((ArrayList)list, "student.txt", Risk.class) ;
    }

    Connection conn = null;
    Statement stmt = null;
    public int getMaxId(){
    	return list.size() ;
    }
    public ArrayList<Risk> getAllRisks() {
//        System.out.println("111");
//        List<Risk> res = new ArrayList<Risk>();
//        //res.addAll(req.getMyOtherCourses(studentId));
//        String sql = "select * from risk ";
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                int riskId = rs.getInt(1);
//                String riskName = rs.getString(2);
//                String riskContent = rs.getString(3);
//                String riskLevel = rs.getString(4);
//                String riskPossibility = rs.getString(5);
//                String riskGate = rs.getString(6);
//                String riskCreator = rs.getString(7);
//                String riskFollower = rs.getString(8);
//                String riskCreatedTime = rs.getString(9);
//
//                Risk r = new Risk(riskId, riskName, riskContent, riskLevel, riskPossibility, riskGate, riskCreator,riskFollower,riskCreatedTime);
//
//                res.add(r);
//            }
//            return res;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
    	return list ;

    }


    public void addRisk(Risk risk) {

        //res.addAll(req.getMyOtherCourses(studentId));
//        String sql = "insert into risk values (0,"+risk.getRiskName()+","+risk.getRiskContent()+","+risk.getRiskLevel()+","+risk.getRiskPossibility()+"," +
//                ","+risk.getRiskGate()+","+risk.getRiskCreator()+","+risk.getRiskFollower()+","+risk.getRiskCreatedTime()+")";
//
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    	list.add(risk) ;

    }

    public void deleteRisk(int  risk_id) {

        //res.addAll(req.getMyOtherCourses(studentId));
//        String sql = "delete  from risk where risk_id = "+ risk_id ;
//        try {
//            boolean rs = stmt.execute(sql);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    	Risk therisk = null ;
    	for(Risk risk:list){
    		if(risk.getRiskId()==risk_id){
    			therisk = risk ;
    			break  ;
    		}
    	}
    	list.remove(therisk) ;

    }


    public Risk getRisk(int risk_id) {
//        String sql = "select * from risk where *.risk_id = "+ risk_id ;
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            int riskId = rs.getInt(1);
//            String riskName = rs.getString(2);
//            String riskContent = rs.getString(3);
//            String riskLevel = rs.getString(4);
//            String riskPossibility = rs.getString(5);
//            String riskGate = rs.getString(6);
//            String riskCreator = rs.getString(7);
//            String riskFollower = rs.getString(8);
//            String riskCreatedTime = rs.getString(9);
//
//            Risk r = new Risk(riskId, riskName, riskContent, riskLevel, riskPossibility, riskGate, riskCreator,riskFollower,riskCreatedTime);
//            return r;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    	Risk therisk = null ;
    	for(Risk risk:list){
    		if(risk.getRiskId()==risk_id){
    			therisk = risk ;
    			therisk = risk  ;
    		}
    	}
    	return therisk ;
    }
	public void update(Risk risk) {
		// TODO Auto-generated method stub
		Risk theRisk = null ;
		for(Risk therisk:list){
			if(risk.getRiskId()==therisk.getRiskId()){
				theRisk = therisk ;
				break ;
			}
		}
		list.remove(theRisk) ;
		list.add(risk) ;
	}
}
