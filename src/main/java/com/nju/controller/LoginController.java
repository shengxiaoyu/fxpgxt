package com.nju.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.UserDO;
import com.nju.service.UserService;

@Controller
public class LoginController {
	@Autowired
    private UserService userService;
	 @RequestMapping(value = "Login.do" , method = RequestMethod.POST)
	    public String postlogin(HttpServletRequest request,
				HttpServletResponse response, HttpSession session){
	    	String username = request.getParameter("username") ;
	    	String password = request.getParameter("password") ;
	        System.out.println(username);
	        System.out.println(password);
	        if(password.equals(userService.getUserPass(username))){
	        	System.out.println("login success");
	        	UserDO user = userService.getUserByName(username) ;
	        	session.setAttribute("user", user) ;
	            return "redirect:main.do";
	        }
	        return "login";
	    }

	    @RequestMapping(value = "logout.do" , method = RequestMethod.GET)
	    public String logout(HttpSession session){
	        
	        session.removeAttribute("user");
	        return "login";
	    }
	    @RequestMapping(value="register.do",method = RequestMethod.POST)
	    public String register(HttpServletRequest request,
				HttpServletResponse response, ModelMap model){
		    	String username = request.getParameter("username") ;
		    	String password = request.getParameter("password") ;
		    	String firmPasswordord = request.getParameter("confirmPassword") ;
		    	if(password.equals(firmPasswordord)){
		    	UserDO user = new UserDO() ;
		    	user.setName(username) ;
		    	user.setPassword(password) ;
		    	userService.register(user) ;
		    	
		    	return "login" ;
	    	}else{
	    		return "register" ;
	    	}
	    }
}
