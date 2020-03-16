package com.neuesoft.blog.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.pojo.Comment_List;

public class Comment_ListDao {
	ArrayList<Comment_List> list=new  ArrayList<Comment_List>();
	public  ArrayList<Comment_List>   queryAll(String  currentPage) throws  Exception{
		
		int p=Integer.parseInt(currentPage);
		String  sql="select  * from   comment   limit  "+(p-1)*Resource.PAGETOTAL+","+Resource.PAGETOTAL ;
		//System.out.println(sql);
	    ResultSet  rs=JDBCTool.executeQuery(sql);
	    Comment_List  obj=null;
	    while(rs.next()){
	    	obj=new Comment_List();
	    	obj.setCid(rs.getInt("cid"));
	    	obj.setAuthor(rs.getString("author"));
	    	obj.setContent(rs.getString("content"));
	    	obj.setCreated(rs.getString("created"));
	    	obj.setIp(rs.getString("ip"));;
	    	obj.setStatus(rs.getString("status"));
	    	obj.setAid(rs.getInt("aid"));
	    	//System.out.println("aid"+obj.getaid());
	    	list.add(obj);
	    }
	    return  list;
	}
	
	public    String  queryPageTotal() throws  Exception{
		String  sql="select  count(*) as c from   comment";
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
		String  sql="delete  from  comment  where  cid="+cid;
		JDBCTool.execute(sql);
	}
	
	public  Comment_List  queryById(String cid) throws Exception{
		String  sql="select  * from  comment  where  cid="+cid;
		ResultSet  rs=JDBCTool.executeQuery(sql);
		Comment_List  obj=null;
		if(rs.next()){
			obj=new Comment_List();
	    	obj.setCid(rs.getInt("cid"));
	    	obj.setAuthor(rs.getString("author"));
	    	obj.setContent(rs.getString("content"));
	    	obj.setCreated(rs.getString("created"));
	    	obj.setIp(rs.getString("ip"));;
	    	obj.setStatus(rs.getString("status"));
	    	obj.setAid(rs.getInt("aid"));
		}
		return obj;
	}
	
	public void updateByStatus(String cid,String status){
		String sql="update comment set status='"+status+"' where cid="+cid;
		System.out.println(sql);
		JDBCTool.execute(sql);			
	}


}
