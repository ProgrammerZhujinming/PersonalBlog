package com.neuesoft.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.pojo.Category;

public class CategoryDao {

	public  ArrayList<Category>   queryAll(String  currentPage) throws  Exception{
		int p=Integer.parseInt(currentPage);
	    //limit   a,b
		//b   对应数字五   a    1  0   2 5  3 10  4  15
		String  sql="select  * from   category   limit  "+(p-1)*Resource.PAGETOTAL+","+Resource.PAGETOTAL ;
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
	
	public    String  queryPageTotal() throws  Exception{
		String  sql="select  count(*) as c from   category";
		ResultSet rs=JDBCTool.executeQuery(sql);
		int total=0;
		if(rs.next()){
			total=rs.getInt("c");
		}
		int result=total/Resource.PAGETOTAL;
		if(result%Resource.PAGETOTAL>0){
			result=result+1;
		}
		return result+"";
		
	}
	
	public  void  deleById(String cid){
		String  sql="delete  from  category  where  cid="+cid;
		JDBCTool.execute(sql);
	}
	
	public  Category  queryById(String cid) throws Exception{
		String  sql="select  * from  category  where  cid="+cid;
		ResultSet  rs=JDBCTool.executeQuery(sql);
		Category  obj=null;
		if(rs.next()){
			obj=new Category();
	    	obj.setCid(rs.getInt("cid"));
	    	obj.setName(rs.getString("name"));
	    	obj.setDescription(rs.getString("description"));
		}
		return obj;
	}
	
	public void updateByCid(String cid,String name,String description){
		String  sql="update   category  set name='"+name+"',description='"+description+"' where  cid="+cid;
		System.out.println(sql);
		JDBCTool.execute(sql);
	}
	
	public void addByname(String cname){
		String sql="insert into category (name,description) values('"+cname+"','')";
		System.out.println(sql);
		JDBCTool.execute(sql);
	}
	
}
