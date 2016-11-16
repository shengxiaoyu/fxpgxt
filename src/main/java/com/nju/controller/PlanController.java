package com.nju.controller;

import java.nio.channels.FileChannel.MapMode;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.PlanDO;
import com.nju.data.dataobject.RiskDO;
import com.nju.service.PlanService;
import com.nju.service.RiskFollowerService;
import com.nju.service.RiskService;
import com.nju.util.ValueComparator;

@Controller
public class PlanController {
	@Autowired
	private RiskFollowerService followerService ;
	@Autowired
	private PlanService planService ;
	@Autowired
	private RiskService riskService ;
	
	@RequestMapping(value="managerPlan.do",method=RequestMethod.POST)
	public String showPlans(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List<PlanDO> plans = planService.getAllPlans() ;
		model.addAttribute("planList", plans) ;
		return "managerPlan" ;
	}
	
	@RequestMapping(value="getPlanDetail.aj",method=RequestMethod.POST)
	public String getPlanDetail(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		int pid = Integer.parseInt(request.getParameter("pid")) ;
		List<RiskDO> risks = planService.getPlanDetail(pid) ;
		model.addAttribute("riskList", risks) ;
		return "planDetail" ;
	}
	
	@RequestMapping(value="getRecognizedRiskList.aj",method=RequestMethod.POST)
	public void getRecognizedRiskList(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String begin = request.getParameter("beginTime") ;
		String end = request.getParameter("endTime") ;
		Map<Integer,Integer> map = riskService.getRecognizedTimes(begin, end) ;
		ValueComparator vc = new ValueComparator(map) ;
		TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(vc) ;
		model.addAttribute("riskMap",sorted_map) ;
	}
	@RequestMapping(value="getComeTrueRiskList.aj",method=RequestMethod.POST)
	public void getComeTrueRiskList(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String begin = request.getParameter("beginTime") ;
		String end = request.getParameter("endTime") ;
		Map<Integer,Integer> map = riskService.getComeTrueTimes(begin, end) ;
		ValueComparator vc = new ValueComparator(map) ;
		TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(vc) ;
		model.addAttribute("riskMap",sorted_map) ;
	}
	

}
