package com.neuesoft.blog.service;

import com.neuesoft.blog.common.Resource;
import com.neuesoft.blog.common.Result;
import com.neuesoft.blog.dao.UserDao;
import com.neuesoft.blog.pojo.User;

public class UserService {
	private  UserDao  userDao=new UserDao();
	
   public   Result   checkVerify(String  answer,String verifyCode){
		Result  rs=new  Result();
    	if(answer.equals(verifyCode)){
    		rs.setMsg("��֤����ȷ");
    		rs.setCode(Resource.SUCCESS);
        }else{
    	 rs.setMsg("��֤�����");
		 rs.setCode(Resource.USER_ERROR);
        }
    	return  rs;
   }
   
   public   User  loadUserByName(String  username) throws Exception{
	  return   userDao.queryByUserName(username);
   }
   
   public  Result login(String username,String password){
	   User  user=null;
	   Result  rs=new  Result();
	   try {
		user=loadUserByName(username);
		if(user.getPassword().equals(password)){
			rs.setCode(Resource.SUCCESS);
			rs.setMsg("��¼�ɹ�");
		}else{
			rs.setCode(Resource.USER_ERROR);
			rs.setMsg("��¼ʧ�ܣ��û������������");
		}
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		rs.setCode(Resource.ERROR);
		rs.setMsg("��¼ʧ�� ");
	   }
	   return  rs;
   }
   
  
   
   
   
}
