package com.neuesoft.blog.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.pojo.Article;
import com.neuesoft.blog.pojo.Category;



public class ArticleDao {
	ArrayList<Article> list=new  ArrayList<Article>();
	Article  obj=null;
	public  ArrayList<Article>   queryAll(String  currentPage) throws  Exception{
		int p=Integer.parseInt(currentPage);
		String  sql="select  * from   article   limit  "+(p-1)*Resource.PAGETOTAL+","+Resource.PAGETOTAL ;
	    ResultSet  rs=JDBCTool.executeQuery(sql);
	    
	    while(rs.next()){
	    	obj=new Article();
	    	obj.setAid(rs.getInt("aid"));
	    	obj.setTitle(rs.getString("title"));
	    	obj.setContent(rs.getString("content"));
	    	obj.setIntro(rs.getString("intro"));
	    	obj.setStatus(rs.getString("status"));
	    	obj.setHits(rs.getInt("hits"));
	    	obj.setAllow_comment(rs.getString("allow_comment"));
	    	obj.setModified(rs.getString("modified"));
	    	obj.setCreated(rs.getString("created"));
	    	list.add(obj);
	    }
	    
	    return  list;
	}
	
	public    String  queryPageTotal() throws  Exception{
		String  sql="select  count(*) as c from   article";
		ResultSet rs=JDBCTool.executeQuery(sql);
		int total=0;
		if(rs.next()){
			total=rs.getInt("c");
		}
		int result=total/Resource.PAGETOTAL;
		if(result%Resource.PAGETOTAL>0){
			++result;
		}
		return result+"";
		
	}
	
	public  void deleteById(String aid) {
		String  sql="delete  from  article  where  aid="+aid;
		System.out.println(sql);
		JDBCTool.execute(sql);
	}

		public  Article  queryById(String aid) throws Exception{
		String  sql="select  * from  article  where  aid="+aid;
		ResultSet  rs=JDBCTool.executeQuery(sql);
		Article  obj=null;
		if(rs.next()){
			obj=new Article();
			obj.setAid(rs.getInt("aid"));
	    	obj.setTitle(rs.getString("title"));
	    	obj.setContent(rs.getString("content"));
	    	obj.setIntro(rs.getString("intro"));
	    	obj.setStatus(rs.getString("status"));
	    	obj.setHits(rs.getInt("hits"));
	    	obj.setAllow_comment(rs.getString("allow_comment"));
	    	obj.setModified(rs.getString("modified"));
	    	obj.setCreated(rs.getString("created"));
		}
		return obj;
	}
		
		
		//文章所属分类查询
		/*public  void categoryQuery(String aid){
			String cid_sql="select cid from category_article where aid="+aid;
			JDBCTool.execute(cid_sql);
			String name_sql="select name form category where cid="+cid_sql;
			JDBCTool.execute(cid_sql);
		}*/
		
		
		
		
		//文章所属分类查询
		public  ArrayList<Category>  queryByCid(String aid) throws Exception{
			
			String  sql="select cid from category_article where aid="+aid;		
			System.out.println(sql);
			ResultSet  rs=JDBCTool.executeQuery(sql);
			Category  obj=null;
			Category  objs=null;
			ArrayList<Category> list=new ArrayList<Category>();
		    while(rs.next()){
		    	obj=new Category();
		    	obj.setCid(rs.getInt("cid"));
		    	int cid=obj.getCid();
			    String sqls="select * from category where cid="+cid;
			    System.out.println(sqls);
			    ResultSet rss=JDBCTool.executeQuery(sqls);
			    System.out.println(rss);
			    while(rss.next()){
			    	objs=new Category();
			    	objs.setName(rss.getString("name"));
			    	list.add(objs);
			    	System.out.println(objs.getName());
			    }
			    //list.add(objs);
		    }
		    
		    return  list;
		}//文章所属分类查询
}
