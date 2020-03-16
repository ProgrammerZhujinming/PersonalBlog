package com.neuesoft.blog.service;

import com.neuesoft.blog.common.Pagion;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.CategoryDao;

public class CategoryService {
   private  CategoryDao  cateDao=new  CategoryDao();
   
   public   Result   backCategoriesByPagion(String currentPage){
	    Result  rs=new Result();
	    try {
			 rs.setData(cateDao.queryAll(currentPage));
			 rs.setCode(Resource.SUCCESS);
			 Pagion  page=new Pagion();
			 page.setCurrentPage(currentPage);
			 page.setPageTotal(cateDao.queryPageTotal());
			 rs.setPage(page);
			 rs.setMsg("返回分类列表成功");
		} catch (Exception e) {
			rs.setCode(Resource.ERROR);
			rs.setMsg("返回分类列表失败");
			e.printStackTrace();
		}
	    return  rs;
   }
   
   
   public   Result   removeById(String cid){
	   Result  rs=new Result();
	   try{
	      cateDao.deleById(cid);
	      rs.setCode(Resource.SUCCESS);
	      rs.setMsg("删除成功");
	   }catch(Exception e){
		   e.printStackTrace();
		   rs.setCode(Resource.ERROR);
		      rs.setMsg("删除失败");
	   }
	    return  rs;
   }
   
   public Result   backById(String cid){
	   Result  rs=new  Result();
	   try {
		rs.setData(cateDao.queryById(cid));
		rs.setCode(Resource.SUCCESS);
		rs.setMsg("返回分类信息成功");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		rs.setCode(Resource.ERROR);
		rs.setMsg("返回分类信息失败");
	} 
	  return  rs;
   }
   
   public   Result   updateById(String cid,String name,String description){
	   Result  rs=new Result();
	   try{
	      cateDao.updateByCid(cid, name, description);
	      rs.setCode(Resource.SUCCESS);
	      rs.setMsg("更新成功");
	   }catch(Exception e){
		   e.printStackTrace();
		   rs.setCode(Resource.ERROR);
		      rs.setMsg("更新失败");
	   }
	    return  rs;
   }
   
   public   Result   add(String name){
	   Result  rs=new Result();
	   try{
	      cateDao.addByname(name);
	      rs.setCode(Resource.SUCCESS);
	      rs.setMsg("增加成功");
	   }catch(Exception e){
		   e.printStackTrace();
		   rs.setCode(Resource.ERROR);
		      rs.setMsg("增加失败");
	   }
	    return  rs;
   }
   
}
