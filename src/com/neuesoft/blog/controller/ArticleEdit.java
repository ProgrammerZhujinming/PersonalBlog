package com.neuesoft.blog.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;
import com.neuesoft.blog.common.JsonTool;
import com.neuesoft.blog.common.WriterTool;
import com.neuesoft.blog.pojo.Article;
import com.neuesoft.blog.service.ArticleEditService;
import com.neuesoft.blog.service.CategoryService;
@Controller
public class ArticleEdit {

	private  ArticleEditService ArticleEditService=new ArticleEditService();
   @RequestMapping("/getArticleById.do")  // ok
   public void 	getArticleById(HttpServletRequest req,HttpServletResponse resp){
		int aid=Integer.parseInt(req.getParameter("aid"));// 得到了aid 查询aid 通过aid 查文章返回categories数组
		WriterTool.write(resp, JsonTool.turnToJson(ArticleEditService.BackArticle(aid)));	
		System.out.println(JsonTool.turnToJson(ArticleEditService.BackArticle(aid)));
		
	}
	@RequestMapping("/saveArticle.do")   //ok
	public void insertArticle(HttpServletRequest req,HttpServletResponse resp) throws SQLException{
		String[] cid=req.getParameter("category").split(",");		  //这里得到了这个文章的有哪些分类
		Article a=new Article();
		a.setAllow_comment(req.getParameter("allow_comments"));
		a.setContent(req.getParameter("content"));
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
     	a.setHits(0);
		a.setIntro(req.getParameter("intro"));
		a.setStatus(req.getParameter("status"));
		a.setTitle(req.getParameter("title"));
		System.out.println(req.getParameter("aid"));
		if(req.getParameter("aid").equals("-1")){
	    	 a.setCreated(df.format(new Date()));
	    	 WriterTool.write(resp, JsonTool.turnToJson(ArticleEditService.SaveArticle(a,cid,ArticleEditService.backDataNum())));  	
	}else{
		 a.setAid(Integer.parseInt(req.getParameter("aid")));
	    	a.setModified(df.format(new Date()));
		 WriterTool.write(resp, JsonTool.turnToJson(ArticleEditService.UpdateArti(a,cid)));	
	}
	
	}
	@RequestMapping("/articleCategory.do")  //
	public  void  getCategory (HttpServletRequest req,HttpServletResponse resp){
		WriterTool.write(resp, JsonTool.turnToJson(ArticleEditService.backCategories()));
	}
	@RequestMapping("/getUnSelectCategory.do")
	public  void  getUnSelectCategory (HttpServletRequest req,HttpServletResponse resp){
		WriterTool.write(resp, JsonTool.turnToJson(ArticleEditService.backCategories()));

	}
}
