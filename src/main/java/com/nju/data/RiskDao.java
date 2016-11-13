package com.nju.data;

import com.nju.model.Risk;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



@Repository
public class RiskDao {
	private static List<Risk> list = new ArrayList<Risk>() ;
	
    static {
    	Risk r1 = new Risk(0, "risk1", "risk1", "1", "50%", "50%", "testOne", "testTwo", "2016/11/10") ;
    	Risk r2 = new Risk(0, "risk1", "risk1", "2", "50%", "50%", "testOne", "testTwo", "2016/11/10") ;
    	Risk r3 = new Risk(0, "risk1", "risk1", "3", "50%", "50%", "testOne", "testTwo", "2016/11/10") ;
    	Risk r4 = new Risk(0, "risk1", "risk1", "4", "50%", "50%", "testTwo", "testOne", "2016/11/11") ;
    	Risk r5 = new Risk(0, "risk1", "risk1", "5", "50%", "50%", "testTwo", "testOne", "2016/11/12") ;
    	Risk r6 = new Risk(0, "risk1", "risk1", "6", "50%", "50%", "testTwo", "testOne", "2016/11/13") ;
    	list.add(r1) ;
    	list.add(r2) ;
    	list.add(r3) ;
    	list.add(r4) ;
    	list.add(r5) ;
    	list.add(r6) ;
    	
    }

    Connection conn = null;
    Statement stmt = null;

    public List<Risk> getAllRisks() {
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
}
