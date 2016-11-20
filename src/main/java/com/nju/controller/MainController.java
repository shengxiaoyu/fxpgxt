package com.nju.controller;


import com.nju.data.dataobject.RiskDO;
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.data.dataobject.UserDO;
import com.nju.service.RiskFollowerService;
import com.nju.service.RiskService;
import com.nju.service.UserService;
import com.nju.service.model.ChartDataModel;
import com.nju.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;



@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private RiskService riskService ;
    @Autowired
    private RiskFollowerService followerService ;
   
    @RequestMapping(value = "main.do",method=RequestMethod.GET)
    public String getMain(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
//        List<RiskDO> riskList = riskService.getAllRisks();
		String begin = request.getParameter("begin") ;
		String end = request.getParameter("end") ;
		if(begin==null){
			begin = "2016-11-01" ;
		}else if(begin==""||begin.equals("undefined")){
			begin = "2016-11-01" ;
		}
		if(end==null){
			end = DateUtil.FormatDate(new Date()) ;
		}else if(end==""||end.equals("undefined")){
			end = DateUtil.FormatDate(new Date()) ;
		}
    	List<UserDO> users = userService.getAllUsers() ;
        UserDO user = (UserDO) request.getSession().getAttribute("user") ;
        model.addAttribute("user", user) ;
        model.addAttribute("followers", users) ;
		model.addAttribute("begin",begin) ;
		model.addAttribute("end",end) ;
//      model.addAttribute("riskList", riskList) ;
        return "main" ; 
    }

    
    @RequestMapping(value = "getAllStudents.aj", method = RequestMethod.POST)
    @ResponseBody
    public List<UserDO> getAllStudents(){
        return userService.getAllUsers() ;
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
    public void addRisk(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
    	String name = request.getParameter("riskName") ;
    	String content = request.getParameter("riskContent") ;
    	String creator = request.getParameter("riskCreator") ;
        RiskDO risk = new RiskDO(riskService.getMaxId(), name, content, creator) ;
        riskService.addRisk(risk);
    }

    @RequestMapping(value = "/assignRisk.aj", method = RequestMethod.POST)
    @ResponseBody
    public boolean followRisk(HttpServletRequest request,
			HttpServletResponse response){
    	String[] followers = request.getParameter("followers").split(",") ;
    	int maxId = followerService.getMaxId() ;
    	for(String username:followers){
    		UserDO user = userService.getUserByName(username) ;
    		if(user==null){
    			break ;
    		}
        	RiskFollowerDO riskFollower = new RiskFollowerDO() ;
        	riskFollower.setId(maxId++) ;
        	riskFollower.setUId(user.getId()) ;
        	String id = request.getParameter("riskId") ;
        	riskFollower.setRId(Integer.valueOf(id)) ;;
        	riskFollower.setBeginTime(DateUtil.getTime()) ;
        	followerService.assignRisk(riskFollower) ;
    	}
        return true;
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
    @RequestMapping(value="getChartData.aj",method=RequestMethod.POST)
    @ResponseBody
    public List<ChartDataModel> getChartData(HttpServletRequest request,
			HttpServletResponse response){
    	String begin = request.getParameter("begin") ;
    	String end = request.getParameter("end") ;
    	return  riskService.getChartData(begin, end) ;
    }
}
