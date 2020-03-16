package com.neuesoft.blog.controller;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.Content;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;
import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.common.JsonTool;
import com.neuesoft.blog.common.WriterTool;
import com.neuesoft.blog.service.CounterService;
import com.neuesoft.blog.service.UserService;

@Controller
public class CounterController {
	
private CounterService cs=new CounterService();
	
@RequestMapping("/dashboard.do")
public void dashboard(HttpServletRequest req,HttpServletResponse resp) throws Exception {
//	String  articleCount=req.getParameter("articleCount");
//	WriterTool.write(resp, JsonTool.turnToJson(CounterService.));
	//System.out.println("sdaewr");
	WriterTool.write(resp, JsonTool.turnToJson(cs.counterArticle()));
}
@RequestMapping("/logout.do")
public   void  logout(HttpServletRequest req,HttpServletResponse resp){
	
	WriterTool.write(resp, JsonTool.turnToJson(cs.logout()));
}

@RequestMapping("/bacc.do")
public void bacc(HttpServletRequest req,HttpServletResponse resp) throws Exception {
	int aid = Integer.parseInt(req.getParameter("aid"));
//	int cid = Integer.parseInt(req.getParameter("cid"));
	
	WriterTool.write(resp, JsonTool.turnToJson(cs.articleContent(aid)));
	//WriterTool.write(resp, JsonTool.turnToJson(cs.commentContent(cid)));
	System.out.println(JsonTool.turnToJson(cs.articleContent(aid)));
	
	
}
}

