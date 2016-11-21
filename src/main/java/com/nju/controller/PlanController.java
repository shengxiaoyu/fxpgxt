package com.nju.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
import com.nju.data.dataobject.UserDO;
import com.nju.service.PlanService;
import com.nju.service.RiskFollowerService;
import com.nju.service.RiskService;
import com.nju.service.UserService;
import com.nju.service.model.RowModel;
import com.nju.util.DateUtil;
import com.nju.util.ValueComparator;

@Controller
public class PlanController {
	@Autowired
	private UserService userService;
	@Autowired
	private RiskFollowerService followerService ;
	@Autowired
	private PlanService planService ;
	@Autowired
	private RiskService riskService ;
	
	@RequestMapping(value="managerPlan.do",method=RequestMethod.GET)
	public String showPlans(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List<PlanDO> plans = planService.getAllPlans() ;
		model.addAttribute("planList", plans) ;
		List<UserDO> users = userService.getAllUsers() ;
        UserDO user = (UserDO) request.getSession().getAttribute("user") ;
        String begin = "2016-11-01" ;
        String end = DateUtil.FormatDate(new Date()) ;
        model.addAttribute("begin", begin) ;
        model.addAttribute("end", end) ;
        model.addAttribute("user", user) ;
        model.addAttribute("followers", users) ;
		return "managerPlan" ;
	}
	
	@RequestMapping(value="getPlanDetail.aj",method=RequestMethod.POST)
	public String getPlanDetail(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String planId = request.getParameter("pid") ;
		int pid = Integer.parseInt(planId) ;
		PlanDO plan = planService.getPlanById(pid) ;
		List<RiskDO> risks = planService.getPlanDetail(pid) ;
		model.addAttribute("plan", plan) ;
		model.addAttribute("riskList", risks) ;
		return "planDetail" ;
	}
	
	@RequestMapping(value="getRecognizedRiskList.aj",method=RequestMethod.POST)
	public String getRecognizedRiskList(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String begin = request.getParameter("beginTime") ;
		String end = request.getParameter("endTime") ;
		if(begin==null||begin.equals("")){
			begin = "2016-11-01" ;
		}
		if(end==null||end.equals("")){
			end = DateUtil.FormatDate(new Date()) ;
		}
		Map<Integer,Integer> map = riskService.getRecognizedTimes(begin, end) ;
		List<Map.Entry<Integer, Integer>> maplist = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet()) ;
		Collections.sort(maplist,new Comparator<Map.Entry<Integer,Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return -o1.getValue().compareTo(o2.getValue());
			}
			
		}) ;
		List<RowModel> list = new ArrayList<RowModel>() ;
		for(Map.Entry<Integer, Integer> e:maplist){
			list.add(new RowModel(e.getKey(),riskService.getRisk(e.getKey()).getName(),e.getValue())) ;
		}
		model.addAttribute("list",list) ;
		return "tbody" ;
	}
	@RequestMapping(value="getComeTrueRiskList.aj",method=RequestMethod.POST)
	public String getComeTrueRiskList(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String begin = request.getParameter("beginTime") ;
		String end = request.getParameter("endTime") ;
		if(begin==null||begin.equals("")){
			begin = "2016-11-01" ;
		}
		if(end==null||end.equals("")){
			end = DateUtil.FormatDate(new Date()) ;
		}
		Map<Integer,Integer> map = riskService.getComeTrueTimes(begin, end) ;
		List<Map.Entry<Integer, Integer>> maplist = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet()) ;
		Collections.sort(maplist,new Comparator<Map.Entry<Integer,Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return -o1.getValue().compareTo(o2.getValue());
			}
			
		}) ;
		List<RowModel> list = new ArrayList<RowModel>() ;
		for(Map.Entry<Integer, Integer> e:maplist){
			list.add(new RowModel(e.getKey(),riskService.getRisk(e.getKey()).getName(),e.getValue())) ;
		}
		model.addAttribute("list",list) ;
		return "tbody" ;
	}
	
	@RequestMapping(value="addRiskForPlan.aj",method=RequestMethod.POST)
	public void addRiskForPlan(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String planId = request.getParameter("planId") ;
		String riskName = request.getParameter("riskName") ;
		String riskContent = request.getParameter("riskContent") ;
		String riskCreator = request.getParameter("riskCreator") ;
		RiskDO risk = new RiskDO() ;
		risk.setName(riskName) ;
		risk.setContent(riskContent) ;
		risk.setCreator(riskCreator) ;
		risk.setId(riskService.getMaxId()) ;
		riskService.addRisk(risk) ;
		PlanDO plan = planService.getPlanById(Integer.parseInt(planId)) ;
		planService.addRiskIntoPlan(plan, risk) ;
	}
	@RequestMapping(value="deleteRiskFromPlan.aj",method=RequestMethod.POST)
	public void deleteRiskFromPlan(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String pid = request.getParameter("pid") ;
		String rid = request.getParameter("rid") ;
		RiskDO risk = riskService.getRisk(Integer.parseInt(rid)) ;
		PlanDO plan = planService.getPlanById(Integer.parseInt(pid)) ;
		planService.deleteRiskFromPlan(plan, risk) ;
	}
	@RequestMapping(value="updateRiskInPlan.aj",method=RequestMethod.POST)
	public void updateRiskInPlan(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String pid = request.getParameter("pid") ;
		String rid = request.getParameter("rid") ;
		RiskDO risk = riskService.getRisk(Integer.parseInt(rid)) ;
		PlanDO plan = planService.getPlanById(Integer.parseInt(pid)) ;
		planService.deleteRiskFromPlan(plan, risk) ;
		
		String risk_name = request.getParameter("riskName") ;
		String risk_content = request.getParameter("riskContent") ;
		RiskDO newRisk = new RiskDO() ;
		newRisk.setName(risk_name) ;
		newRisk.setContent(risk_content) ;
		int newRid = riskService.getMaxId() ;
		newRisk.setId(newRid) ;
		UserDO user = (UserDO) request.getSession().getAttribute("user") ;
		newRisk.setCreator(user.getName()) ;
		riskService.addRisk(newRisk) ;
		planService.addRiskIntoPlan(plan, newRisk) ;
	}
	@RequestMapping(value="addPlan.aj",method=RequestMethod.POST)
	public void addPlan(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String planName = request.getParameter("planName") ;
		PlanDO plan = new PlanDO() ;
		plan.setName(planName) ;
		int id =planService.getMaxId() ;
		plan.setId(id) ;
		planService.addPlan(plan) ;
	}
	@RequestMapping(value="addRisksIntoPlan.aj",method=RequestMethod.POST)
	public void addRisksIntoPlan(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		String riskIds = request.getParameter("rids") ;
		String pid = request.getParameter("pid") ;
		String[] rids = riskIds.split(":") ;
		PlanDO plan = planService.getPlanById(Integer.parseInt(pid)) ;
		for(int i=0;i<rids.length;i++){
			RiskDO risk = riskService.getRisk(Integer.parseInt(rids[i])) ;
			planService.addRiskIntoPlan(plan, risk) ;
		}
	}
}
