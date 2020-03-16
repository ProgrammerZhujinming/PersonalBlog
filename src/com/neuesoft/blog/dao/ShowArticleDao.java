package com.neuesoft.blog.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.pojo.Article;
import com.neuesoft.blog.pojo.Category;
import com.neuesoft.blog.pojo.ShowArticle;

public class ShowArticleDao {
	 private ShowArticle showArticle=new ShowArticle();
	 public  ShowArticle  queryByAid(String aid) throws Exception{
		 ArrayList<String> categorylist=new ArrayList<String>();
		 Article article=new Article();
		   ResultSet rs=JDBCTool.executeQuery("select  * from category  where  aid='"+aid+"'");
		   while(rs.next()){
			   categorylist.add(new String(rs.getString("name")));
		   }
		   rs=JDBCTool.executeQuery("select  * from article  where  aid='"+aid+"'");
		   if(rs.next()){
			   article.setAid(rs.getInt("aid"));
			   article.setTitle(rs.getString("title"));
			   article.setContent(rs.getString("content"));
			   article.setIntro(rs.getString("intro"));
			   article.setStatus(rs.getString("status"));
			   article.setHits(rs.getInt("hits"));
			   article.setAllow_comment(rs.getString("allow_comment"));
			   article.setModified(rs.getString("modified"));
			   article.setCreated(rs.getString("created"));
		   }
		   showArticle.setArticle(article);
		   showArticle.setCategorylist(categorylist);
		   return showArticle;
	   }
}
