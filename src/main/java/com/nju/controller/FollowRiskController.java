package com.nju.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.data.dataobject.UserDO;
import com.nju.service.RiskFollowerService;
import com.nju.util.DateUtil;

@Controller
public class FollowRiskController {
	@Autowired
	RiskFollowerService followerService ;
	
	@RequestMapping(value="followedRisks.do",method = RequestMethod.GET)
	public String showFollowedRisks(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		UserDO user = (UserDO) request.getSession().getAttribute("user") ;
		List<RiskFollowerDO> list = new ArrayList<RiskFollowerDO>() ;
		if(user!=null){
			followerService.getFollowedRiskByUId(user.getId()) ;
			model.addAttribute("followedRisksList", list) ;
		}
		return "follow" ;
	}
	@RequestMapping(value = "/followRisk.aj", method = RequestMethod.POST)
    public boolean followRisk(HttpServletRequest request,
			HttpServletResponse response){
    	UserDO user = (UserDO) request.getSession().getAttribute("user") ;
    	RiskFollowerDO riskFollower = new RiskFollowerDO() ;
    	riskFollower.setId(followerService.getMaxId()) ;
    	riskFollower.setUId(user.getId()) ;
    	riskFollower.setRId(Integer.valueOf(request.getParameter("id"))) ;
    	riskFollower.setBeginTime(DateUtil.FormatDate(request.getParameter("begin_time"))) ;
    	
    	riskFollower.setPossibility(request.getParameter("possibility")) ;
    	riskFollower.setInfluence(request.getParameter("level")) ;
    	riskFollower.setGate(request.getParameter("gate")) ;
    	riskFollower.setDescription(request.getParameter("description")) ;
    	riskFollower.setEndTime(request.getParameter("endTime").equals(null)?null:DateUtil.getTime()) ;
    	followerService.followRisk(riskFollower) ;
        return true;
    }
}
