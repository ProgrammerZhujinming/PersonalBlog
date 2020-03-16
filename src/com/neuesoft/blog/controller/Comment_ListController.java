package com.neuesoft.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;
import com.neuesoft.blog.common.JsonTool;
import com.neuesoft.blog.common.WriterTool;
import com.neuesoft.blog.service.CategoryService;
import com.neuesoft.blog.service.Comment_ListService;
@Controller
public class Comment_ListController {
	private  Comment_ListService  comment_listService=new  Comment_ListService();
	
	@RequestMapping("/getCommentList.do")
	public void articlelist(HttpServletRequest req,HttpServletResponse resp){
		String  currentPage=req.getParameter("currentPage");
		WriterTool.write(resp, JsonTool.turnToJson(comment_listService.backCommnetListByPagion(currentPage)));
	}
	
	@RequestMapping("/deleteComment.do")
	public void deleteByAid(HttpServletRequest req,HttpServletResponse resp){
		String cid=req.getParameter("cid");
		WriterTool.write(resp, JsonTool.turnToJson(comment_listService.removeById(cid)));
	}
	
	@RequestMapping("/updateStatus.do")
	public void getCategoryByAId(HttpServletRequest req,HttpServletResponse resp){
		String cid=req.getParameter("cid");
		String status=req.getParameter("status");
		System.out.print("cid:"+cid+"  原来的status:"+status+"  ");
		status=(status.equals("0")?"0":"1");
		System.out.println("新的status:"+status);
		WriterTool.write(resp, JsonTool.turnToJson(comment_listService.update(cid, status)));
	}
}
