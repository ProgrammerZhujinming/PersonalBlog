package com.neuesoft.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;
import com.neuesoft.blog.common.JsonTool;
import com.neuesoft.blog.common.WriterTool;
import com.neuesoft.blog.service.CounterService;
import com.neuesoft.blog.service.UserService;

@Controller
public class UserController {
	private   UserService  userService=new UserService();
    @RequestMapping("/login.do")
	public   void  login(HttpServletRequest req,HttpServletResponse resp){
    	String username=  req.getParameter("username");
    	String  password=  req.getParameter("password");
    	WriterTool.write(resp, JsonTool.turnToJson(userService.login(username, password)));
    }
    @RequestMapping("/verify.do")
    public  void    verify(HttpServletRequest req,HttpServletResponse resp) throws IOException{
    	String verifyCode  =req.getParameter("verifyCode");
    	String  answer=(String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        WriterTool.write(resp, JsonTool.turnToJson(userService.checkVerify(answer, verifyCode)));
    }
	
	
   
}
