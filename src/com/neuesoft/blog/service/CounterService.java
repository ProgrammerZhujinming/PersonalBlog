package com.neuesoft.blog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuesoft.blog.common.Pagion;
import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.CounterDao;
import com.neuesoft.blog.pojo.Counter;
import com.neuesoft.blog.pojo.User;

public class CounterService {
	private CounterDao counterDao = new CounterDao();

	public Result  counterArticle() throws Exception {
		Result  rs=new  Result();
		rs.setMsg("获取正确");
		rs.setCode(Resource.SUCCESS);
    	rs.setData(counterDao.queryAll());
    	//rs.getData(counterDao.SelectByAid(aid);
    	//rs.getData(counterDao.SelectByCid(cid);
    	return  rs;
	}

	public Result articleContent(int aid) {
		Result rs = new Result();
		try {
			rs.setData(counterDao.articleContent(aid));
			rs.setCode(Resource.SUCCESS);
			rs.setMsg("获取文章内容成功");
		} catch (Exception e) {
			rs.setCode(Resource.ERROR);
			rs.setMsg("获取文章内容失败");
			e.printStackTrace();
		}
		return rs;
	}
	public Result commentContent(int cid) {
		Result rs = new Result();
		try {
			rs.setData(counterDao.commentContent(cid));
			rs.setCode(Resource.SUCCESS);
			rs.setMsg("获取评论内容成功");
		} catch (Exception e) {
			rs.setCode(Resource.ERROR);
			rs.setMsg("获取评论内容失败");
			e.printStackTrace();
		}
		return rs;
	}
	
	  

	public  Result  logout(){
		// TODO Auto-generated method stub
		  Result  rs=new  Result();
		   try {		
				rs.setCode(Resource.SUCCESS);
				rs.setMsg("退出成功");
			
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setCode(Resource.ERROR);
			rs.setMsg("退出失败 ");
		   }
		   return  rs;
	}
}
