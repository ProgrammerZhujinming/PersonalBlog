package com.neuesoft.blog.service;

import java.util.ArrayList;

import com.neuesoft.blog.common.Pagion;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.CategoryDao;
import com.neuesoft.blog.dao.Comment_ListDao;

public class Comment_ListService {
	private  Comment_ListDao  comment_listDao=new  Comment_ListDao();
	   
	   public   Result   backCommnetListByPagion(String currentPage){
		    Result  rs=new Result();
		    try {
				 rs.setData(comment_listDao.queryAll(currentPage));
				 rs.setCode(Resource.SUCCESS);
				 Pagion  page=new Pagion();
				 page.setCurrentPage(currentPage);
				 page.setPageTotal(comment_listDao.queryPageTotal());
				 rs.setPage(page);
				 rs.setMsg("返回评论列表成功");
			} catch (Exception e) {
				rs.setCode(Resource.ERROR);
				rs.setMsg("返回评论列表失败");
				e.printStackTrace();
			}
		    return  rs;
	   }
	   
	   
	   public   Result   removeById(String cid){
		   Result  rs=new Result();
		   try{
			  comment_listDao.deleById(cid);
		      rs.setCode(Resource.SUCCESS);
		      rs.setMsg("删除成功");
		   }catch(Exception e){
			   e.printStackTrace();
			   rs.setCode(Resource.ERROR);
			   rs.setMsg("删除失败");
		   }
		    return  rs;
	   }
	   
//	   public Result   backById(String cid){
//		   Result  rs=new  Result();
//		   try {
//			rs.setData(comment_listDao.queryById(cid));
//			rs.setCode(Resource.SUCCESS);
//			rs.setMsg("返回分类信息成功");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			rs.setCode(Resource.ERROR);
//			rs.setMsg("返回分类信息失败");
//		} 
//		  return  rs;
//	   }
	  
	   public Result update(String cid,String status){
		   Result rs = new Result();
		   try {
			   comment_listDao.updateByStatus(cid,status);
			   rs.setCode(Resource.SUCCESS);
			   rs.setMsg("修改成功");
		   } catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				rs.setCode(Resource.ERROR);
				rs.setMsg("修改失败");
		  } 
		  return  rs;
	   }
	  
//	   public Result   add(String name){
//		   Result  rs=new  Result();
//		   try {
//			   comment_listDao.addByname(name);
//			rs.setCode(Resource.SUCCESS);
//			rs.setMsg("增加成功");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			rs.setCode(Resource.ERROR);
//			rs.setMsg("增加失败");
//		} 
//		  return  rs;
//	   }

}
