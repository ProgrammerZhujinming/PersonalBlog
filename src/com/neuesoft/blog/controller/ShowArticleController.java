package com.neuesoft.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;
import com.neuesoft.blog.common.JsonTool;
import com.neuesoft.blog.service.ShowArticleService;

@Controller
public class ShowArticleController {
	ShowArticleService showArticle=new ShowArticleService();
	@RequestMapping("/bacc.do")
	public void ShowByAid(HttpServletRequest req,HttpServletResponse resp){
		String aid=req.getParameter("aid");
		System.out.println(JsonTool.turnToJson(showArticle.queryByAid(aid)));
	}
}
