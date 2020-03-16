package com.neuesoft.blog.service;

import com.neuesoft.blog.common.Pagion;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.ArticleDao;


public class ArticleService {
	
	private  ArticleDao  articleDao=new  ArticleDao();
	
	 public   Result   backArticlesByPagion(String currentPage){
		    Result  rs=new Result();
		    try {
				 rs.setData(articleDao.queryAll(currentPage));
				 rs.setCode(Resource.SUCCESS);
				 Pagion  page=new Pagion();
				 page.setCurrentPage(currentPage);
				 page.setPageTotal(articleDao.queryPageTotal());
				 rs.setPage(page);
				 rs.setMsg("返回分类列表成功");
			} catch (Exception e) {
				rs.setCode(Resource.ERROR);
				rs.setMsg("返回分类列表失败");
				e.printStackTrace();
			}
		    return  rs;
	   }
	


	  public Result   backById(String aid){
	   Result  rs=new  Result();
	   try {
		rs.setData(articleDao.queryById(aid));
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
	  
	  
	  
	  
	  public   Result   removeById(String aid){
			   Result  rs=new Result();
			   try{
				   articleDao.deleteById(aid);
			      rs.setCode(Resource.SUCCESS);
			      rs.setMsg("删除成功");
			   }catch(Exception e){
				   e.printStackTrace();
				   rs.setCode(Resource.ERROR);
				      rs.setMsg("删除失败");
			   }
			    return  rs;
		   }
	  
	  
	  
	  //文章所属分类查询
	  public Result BackSelectByCid(String aid) {
		   Result  rs=new Result();
		   try{
			  rs.setData(articleDao.queryByCid(aid));
		      rs.setCode(Resource.SUCCESS);
		      rs.setMsg("查询成功");
		   }catch(Exception e){
			   e.printStackTrace();
			   rs.setCode(Resource.ERROR);
			   rs.setMsg("查询失败");
		   }
		    return  rs;
	   }
}
