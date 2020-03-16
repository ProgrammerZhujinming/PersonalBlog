package com.neuesoft.blog.service;

import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.ShowArticleDao;

public class ShowArticleService {
	private  ShowArticleDao  showArticleDao=new ShowArticleDao();
	public Result queryByAid(String aid) throws Exception {
		Result  rs=new  Result();
    	rs.setData(showArticleDao.queryByAid(aid));
    	rs.setMsg("��ȡ�������ݳɹ�");
    	rs.setCode(Resource.SUCCESS);
    	return rs;
	}
	
}

