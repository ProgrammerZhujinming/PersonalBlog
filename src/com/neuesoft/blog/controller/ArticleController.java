package com.neuesoft.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;
import com.neuesoft.blog.common.JsonTool;
import com.neuesoft.blog.common.WriterTool;
import com.neuesoft.blog.service.ArticleService;

@Controller
public class ArticleController {
	
	private ArticleService articleService=new ArticleService();
	
	@RequestMapping("/articlelist.do")
	public void  showArticle(HttpServletRequest req,HttpServletResponse resp){
		String currentPage=req.getParameter("currentPage");
		 WriterTool.write(resp, JsonTool.turnToJson(articleService.backArticlesByPagion(currentPage)));
	}
	@RequestMapping("/deleteByAid.do")
	public void deleteByAid(HttpServletRequest req,HttpServletResponse resp){
		String aid=req.getParameter("aid");
		System.out.println(aid);
		WriterTool.write(resp, JsonTool.turnToJson(articleService.removeById(aid)));
	}
	@RequestMapping("/getCategoryByAId.do")//À˘ Ù∑÷¿‡
	public void getCategoryByAId(HttpServletRequest req,HttpServletResponse resp){
		String aid=req.getParameter("aid");
		WriterTool.write(resp, JsonTool.turnToJson(articleService.BackSelectByCid(aid)));
	}
	
	

}
