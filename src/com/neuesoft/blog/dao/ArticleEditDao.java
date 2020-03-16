package com.neuesoft.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.pojo.Article;
import com.neuesoft.blog.pojo.Category;

public class ArticleEditDao {
	   public  Article  queryByArticleAid(int aid) throws Exception{
		   ResultSet rs=JDBCTool.executeQuery("select  * from article  where  aid="+aid);
		   Article article=null;
		   if(rs.next()){
			   article=new Article();
			   article.setAid(rs.getInt("aid"));
			   article.setAllow_comment(rs.getString("allow_comment")); 
			   article.setContent(rs.getString("content"));
			   article.setCreated(rs.getString("created"));
			   article.setHits(rs.getInt("hits"));
			   article.setIntro(rs.getString("intro"));
			   article.setModified(rs.getString("modified"));
			   article.setStatus(rs.getString("status"));
			   article.setTitle(rs.getString("title"));
		   }
		   return article;
	   }
		public   ArrayList<Category>  queryCate_ArtiByAid(int aid) throws  Exception{
			String  sql="select  * from   category_article where aid  =" +aid ;
		    ResultSet  rs=JDBCTool.executeQuery(sql);
		    ArrayList<Category> clist=new  ArrayList<Category>();
		    Category  obj=null;
		    while(rs.next()){
		    	String sql2="select  * from   category where cid  ="+rs.getInt("cid");
		    	System.out.println(rs.getInt("cid"));
		        ResultSet  cr=JDBCTool.executeQuery(sql2);
		        while(cr.next()){
		          	obj=new Category();
			    	obj.setCid(cr.getInt("cid"));
			    	obj.setName(cr.getString("name"));
			    	obj.setDescription(cr.getString("description"));
			    	clist.add(obj);
			    	System.out.println("clist add");
		        }
		  
		    }
		    return clist ;
		}
		public void UpdateArticle(Article obj,String cid[]){
			String sql="update article set title='"+obj.getTitle()+"',intro='"+obj.getIntro()+"',content='"+obj.getContent()+"',allow_comment='"+obj.getAllow_comment()+"',status='"+obj.getStatus()+"',modified='"+obj.getModified()+"' where aid="+obj.getAid();
			String sql2="delete from category_article where aid="+obj.getAid();
			 JDBCTool.execute(sql2);
		String sql3;
			 int Cid=0;
		       Set set = new HashSet();
		        for (int i = 0; i < cid.length; i++) {
		            set.add(cid[i]);
		        }
		        cid = (String[]) set.toArray(new String[0]);
		        for (int i = 0; i < cid.length; i++) {
		            System.out.println(cid[i]);
		        }
			 for(int i=0;i<cid.length;i++){
				 Cid=Integer.parseInt(cid[i]);
				 System.out.println(cid[i]);
				 sql3="insert into category_article(cid,aid)values("+Cid+","+obj.getAid()+")";
				 JDBCTool.execute(sql3);
				 System.out.println(sql3);
			 }
			JDBCTool.execute(sql);  //这个还要更新一个表  这儿的aid是有的
		}
		public void insertArticle(Article obj,String cid[],int aid){
			String  sql="insert into  article(title,content,intro,status,hits,allow_comment,modified,created)values('"+obj.getTitle()+"','"+obj.getContent()+"','"+obj.getIntro()+"','"+obj.getStatus()+"',"+obj.getHits()+",'"+obj.getAllow_comment()+"','"+obj.getModified()+"','"+obj.getCreated()+"')";
			 JDBCTool.execute(sql);
			 System.out.println(sql);
			 //假设分类数组为cid   当前文章的aid是 aid；
			 int Cid=0; 
			 String sql2;
			 for(int i=0;i<cid.length;i++){
				 Cid=Integer.parseInt(cid[i]);
				 sql2="insert into category_article(cid,aid)values("+Cid+","+aid+")";
				 JDBCTool.execute(sql2);
				 System.out.println(sql2);
			 }		 
		}
		public int BackAlldata() throws SQLException{
			String sql="select * from article order by aid desc limit 0,1;";
			ResultSet rs=JDBCTool.executeQuery(sql);
			int count=0;
			if(rs.next()){
				System.out.println(sql);
				count=rs.getInt(1);
			}
			return count;
		}
		public  ArrayList<Category>   queryAllCategory() throws  Exception{
			   System.out.println("dao queryAllCategory");
				String  sql="select  * from   category " ;
			    ResultSet  rs=JDBCTool.executeQuery(sql);
			    ArrayList<Category> list=new  ArrayList<Category>();
			    Category  obj=null;
			    while(rs.next()){
			    	obj=new Category();
			    	obj.setCid(rs.getInt("cid"));
			    	obj.setName(rs.getString("name"));
			    	obj.setDescription(rs.getString("description"));
			    	list.add(obj);
			    }
			    return  list;
			}
}
