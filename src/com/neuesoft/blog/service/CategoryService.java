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
			 rs.setMsg("���ط����б�ɹ�");
		} catch (Exception e) {
			rs.setCode(Resource.ERROR);
			rs.setMsg("���ط����б�ʧ��");
			e.printStackTrace();
		}
	    return  rs;
   }
   
   
   public   Result   removeById(String cid){
	   Result  rs=new Result();
	   try{
	      cateDao.deleById(cid);
	      rs.setCode(Resource.SUCCESS);
	      rs.setMsg("ɾ���ɹ�");
	   }catch(Exception e){
		   e.printStackTrace();
		   rs.setCode(Resource.ERROR);
		      rs.setMsg("ɾ��ʧ��");
	   }
	    return  rs;
   }
   
   public Result   backById(String cid){
	   Result  rs=new  Result();
	   try {
		rs.setData(cateDao.queryById(cid));
		rs.setCode(Resource.SUCCESS);
		rs.setMsg("���ط�����Ϣ�ɹ�");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		rs.setCode(Resource.ERROR);
		rs.setMsg("���ط�����Ϣʧ��");
	} 
	  return  rs;
   }
   
   public   Result   updateById(String cid,String name,String description){
	   Result  rs=new Result();
	   try{
	      cateDao.updateByCid(cid, name, description);
	      rs.setCode(Resource.SUCCESS);
	      rs.setMsg("���³ɹ�");
	   }catch(Exception e){
		   e.printStackTrace();
		   rs.setCode(Resource.ERROR);
		      rs.setMsg("����ʧ��");
	   }
	    return  rs;
   }
   
   public   Result   add(String name){
	   Result  rs=new Result();
	   try{
	      cateDao.addByname(name);
	      rs.setCode(Resource.SUCCESS);
	      rs.setMsg("���ӳɹ�");
	   }catch(Exception e){
		   e.printStackTrace();
		   rs.setCode(Resource.ERROR);
		      rs.setMsg("����ʧ��");
	   }
	    return  rs;
   }
   
}
