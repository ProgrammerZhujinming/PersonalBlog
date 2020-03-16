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
				 rs.setMsg("���ط����б�ɹ�");
			} catch (Exception e) {
				rs.setCode(Resource.ERROR);
				rs.setMsg("���ط����б�ʧ��");
				e.printStackTrace();
			}
		    return  rs;
	   }
	


	  public Result   backById(String aid){
	   Result  rs=new  Result();
	   try {
		rs.setData(articleDao.queryById(aid));
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
	  
	  
	  
	  
	  public   Result   removeById(String aid){
			   Result  rs=new Result();
			   try{
				   articleDao.deleteById(aid);
			      rs.setCode(Resource.SUCCESS);
			      rs.setMsg("ɾ���ɹ�");
			   }catch(Exception e){
				   e.printStackTrace();
				   rs.setCode(Resource.ERROR);
				      rs.setMsg("ɾ��ʧ��");
			   }
			    return  rs;
		   }
	  
	  
	  
	  //�������������ѯ
	  public Result BackSelectByCid(String aid) {
		   Result  rs=new Result();
		   try{
			  rs.setData(articleDao.queryByCid(aid));
		      rs.setCode(Resource.SUCCESS);
		      rs.setMsg("��ѯ�ɹ�");
		   }catch(Exception e){
			   e.printStackTrace();
			   rs.setCode(Resource.ERROR);
			   rs.setMsg("��ѯʧ��");
		   }
		    return  rs;
	   }
}
