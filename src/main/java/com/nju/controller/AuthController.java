package com.nju.controller;


import com.nju.data.dataobject.RiskDO;
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.data.dataobject.UserDO;
import com.nju.service.RiskFollowerService;
import com.nju.service.RiskService;
import com.nju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;



@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RiskService riskService ;
    @Autowired
    private RiskFollowerService followerService ;
    @RequestMapping(value = "login.do" , method = RequestMethod.POST)
    public String postlogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
    	String username = request.getParameter("username") ;
    	String password = request.getParameter("password") ;
        System.out.println(username);
        System.out.println(password);
        if(password.equals(userService.getUserPass(username))){
        	System.out.println("login success");
        	session.setAttribute("username", username) ;
            return "main";
        }
        return "login";
    }

    @RequestMapping(value = "logout.do" , method = RequestMethod.GET)
    public String logout(HttpSession session){
        Enumeration<String> em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }
        return "login";
    }

 

 


    @RequestMapping(value = "getAllStudents.aj", method = RequestMethod.POST)
    @ResponseBody
    public List<UserDO> getAllStudents(){
        return userService.getAllUsers() ;
    }





    @RequestMapping(value = "index.do", method = RequestMethod.GET)
    public String index(HttpSession session){
        if(session.getAttribute("id") == null) {
            return "/login";
        }
        return "/index";
    }

    @RequestMapping(value = "course", method = RequestMethod.GET)
    public String course(){
        return "/course";
    }

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String students(){
        return "/students";
    }

    @RequestMapping(value = "getAllRisks.aj", method = RequestMethod.POST)
    @ResponseBody
    public List<RiskDO> getAllRisks(){
        return riskService.getAllRisks();
    }

    @RequestMapping(value = "addRisk.aj", method = RequestMethod.POST)
    @ResponseBody
    public boolean addRisk(@RequestParam String riskName,@RequestParam String riskContent,@RequestParam String riskPossibility,@RequestParam String riskLevel,@RequestParam String riskGate, HttpSession session){

        RiskDO risk = new RiskDO(riskService.getMaxId(), riskName, riskContent, (String)session.getAttribute("username")) ;
        riskService.addRisk(risk);
        return true;
    }

    @RequestMapping(value = "/followRisk.aj", method = RequestMethod.POST)
    @ResponseBody
    public boolean followRisk(HttpServletRequest request,
			HttpServletResponse response){
    	UserDO user = userService.getUserByName(request.getParameter("follower")) ;
    	RiskFollowerDO riskFollower = new RiskFollowerDO() ;
    	riskFollower.setId(followerService.getMaxId()) ;
    	riskFollower.setUId(user.getId()) ;
    	riskFollower.setRId(Integer.valueOf(request.getParameter("id"))) ;
    	riskFollower.setPossibility(request.getParameter("possibility")) ;
    	riskFollower.setInfluence(request.getParameter("level")) ;
    	riskFollower.setGate(request.getParameter("gate")) ;
    	riskFollower.setBeginTime(getTime()) ;
//    	RiskFollower risk = new RiskFollower(Integer.valueOf(request.getParameter("id")), user.getId(),request.getParameter("name"),request.getParameter("content"),request.getParameter("level"), request.getParameter("possibility"), request.getParameter("gate"), request.getParameter("creator"), request.getParameter("follower"), request.getParameter("creator")) ;
//        riskService.followRisk(risk);
    	followerService.followRisk(riskFollower) ;
        return true;
    }


    private Date getTime(){
        Date date = new Date();
//        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time=format.format(date);
        return date;
    }

    @RequestMapping(value = "getRisk.aj", method = RequestMethod.POST)
    @ResponseBody
    public RiskDO getRisk(int risk_id){
        return riskService.getRisk(risk_id);
    }

    @RequestMapping(value = "deleteRisk.aj", method = RequestMethod.POST)
    @ResponseBody
    public void deleteRisk(String risk_id){
        System.out.println(risk_id);
        int riskid=Integer.valueOf(risk_id);
        riskService.deleteRisk(riskid);
    }

}
