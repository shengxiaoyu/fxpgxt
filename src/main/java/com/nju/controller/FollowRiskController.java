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
import com.nju.data.dataobject.RiskFollowerDO;
import com.nju.data.dataobject.UserDO;
import com.nju.service.RiskFollowerService;
import com.nju.service.RiskService;
import com.nju.service.UserService;
import com.nju.service.model.RiskFollowerModel;
import com.nju.util.DateUtil;

@Controller
public class FollowRiskController {
	@Autowired
	private RiskFollowerService followerService ;
	@Autowired
	private UserService userService ;
	@Autowired
	private RiskService riskService ;
	
	@RequestMapping(value="followedRisks.do",method = RequestMethod.GET)
	public String showFollowedRisks(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		UserDO user = (UserDO) request.getSession().getAttribute("user") ;
		List<RiskFollowerModel> modellist = new ArrayList<RiskFollowerModel>() ;
		if(user!=null){
			List<RiskFollowerDO> list = followerService.getFollowedRiskByUId(user.getId()) ;
			for(RiskFollowerDO follower:list){
				modellist.add(new RiskFollowerModel(riskService.getRisk(follower.getRId()), follower, user)) ;
			}
			model.addAttribute("user", user) ;
			model.addAttribute("followedModelList", modellist) ;
		}
		return "follow" ;
	}
	@RequestMapping(value = "followRisk.aj", method = RequestMethod.POST)
    public void followRisk(HttpServletRequest request,
			HttpServletResponse response){
    	UserDO user = (UserDO) request.getSession().getAttribute("user") ;
    	RiskFollowerDO riskFollower = new RiskFollowerDO() ;
    	riskFollower.setId(Integer.valueOf(request.getParameter("id"))) ;
    	riskFollower.setUId(user.getId()) ;
    	riskFollower.setRId(Integer.valueOf(request.getParameter("riskId"))) ;
    	riskFollower.setBeginTime(DateUtil.FormatDate(request.getParameter("begin"))) ;
    	riskFollower.setPossibility(request.getParameter("possibility")) ;
    	riskFollower.setInfluence(request.getParameter("level")) ;
    	riskFollower.setGate(request.getParameter("gate")) ;
    	riskFollower.setDescription(request.getParameter("description")) ;
    	riskFollower.setEndTime(request.getParameter("end").equals(null)?null:DateUtil.getTime()) ;
    	followerService.followRisk(riskFollower) ;
//        return true;
    }
}
