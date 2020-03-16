package com.neuesoft.blog.service;

import java.sql.SQLException;

import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.ArticleEditDao;
import com.neuesoft.blog.pojo.Article;
import com.neuesoft.blog.pojo.Article_Edit;

public class ArticleEditService {
	private ArticleEditDao ArticleEditDao=new ArticleEditDao();
	public Result BackArticle(int aid){
		 Result  rs=new Result();
		 Article_Edit ae=new Article_Edit();
		 try{
			 ae.setArticle(ArticleEditDao.queryByArticleAid(aid));	
			 ae.setCatelist(ArticleEditDao.queryCate_ArtiByAid(aid));//fdsadsa
			 rs.setData(ae);
	          //这个要把关联的东东传进去 rs.setData2(data2);
			 rs.setCode(Resource.SUCCESS);
			 rs.setMsg("加载成功");
		 }catch(Exception e){
			 rs.setCode(Resource.ERROR);
			 rs.setMsg("加载失败");
		 }
		return rs;
		
	}
	public   Result   SaveArticle(Article obj,String[] cid,int aid){
	    Result  rs=new Result();
	    try {
	    	ArticleEditDao.insertArticle(obj,cid,aid);
			 rs.setCode(Resource.SUCCESS);
			 rs.setMsg("保存成功");
		} catch (Exception e) {
			rs.setCode(Resource.ERROR);
			rs.setMsg("保存失败");
			e.printStackTrace();
		}
	    return rs;
  }
	public Result UpdateArti(Article obj,String cid[]){
	    Result  rs=new Result();
	    try {
	    	ArticleEditDao.UpdateArticle(obj,cid);
			 rs.setCode(Resource.SUCCESS);
			 rs.setMsg("保存成功");
		} catch (Exception e) {
			rs.setCode(Resource.ERROR);
			rs.setMsg("保存失败");
			e.printStackTrace();
		}
		return rs;
	}
	public int backDataNum() throws SQLException{
		return ArticleEditDao.BackAlldata();
	}
	   public   Result   backCategories(){
		    Result  rs=new Result();
		    try {
				 rs.setData(ArticleEditDao.queryAllCategory());
				 rs.setCode(Resource.SUCCESS);
				System.out.println("service result");
				 rs.setMsg("catagory加载成功");
			} catch (Exception e) {
				rs.setCode(Resource.ERROR);
				rs.setMsg("category加载失败");
				e.printStackTrace();
			}
		    return  rs;
	  }
}
