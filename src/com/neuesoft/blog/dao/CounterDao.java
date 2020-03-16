package com.neuesoft.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuesoft.blog.common.JDBCTool;
import com.neuesoft.blog.pojo.Article;
import com.neuesoft.blog.pojo.Counter;
import com.neuesoft.blog.pojo.Remark;

public class CounterDao {

	public Counter counter = new Counter();
	public Article article = new Article();
	public Remark remark = new Remark();

	public Counter queryAll() throws Exception {

		ResultSet rs = JDBCTool.executeQuery("select * from article");
		rs.last();
		counter.setAcounts(rs.getRow());
		System.out.println(counter.getAcounts());

		rs = JDBCTool.executeQuery("select * from comment");
		rs.last();
		counter.setCcounts(rs.getRow());

		rs = JDBCTool.executeQuery("select * from fl");
		rs.last();
		counter.setFcounts(rs.getRow());

		rs = JDBCTool.executeQuery("select * from article order by aid desc limit 0,1");

		if (rs != null && rs.next()) {
			article.setAid(rs.getInt("aid"));
			article.setAllow_comment(rs.getString("allow_comment"));
			article.setContent(rs.getString("content"));
			article.setCreated(rs.getString("created"));
			article.setIntro(rs.getString("intro"));
			article.setModified(rs.getString("modified"));
			article.setStatus(rs.getString("status"));
			article.setTitle(rs.getString("title"));
			article.setHits(rs.getInt("hits"));
		}
		counter.setAlist(article);

		rs = JDBCTool.executeQuery("select * from comment order by cid desc limit 0,1");
		if (rs != null && rs.next()) {
			remark.setAid(rs.getInt("aid"));
			remark.setAuthor(rs.getString("author"));
			remark.setCid(rs.getInt("cid"));
			remark.setContent(rs.getString("content"));
			remark.setCreated(rs.getString("created"));
			remark.setIp(rs.getString("ip"));
			remark.setStatus(rs.getString("status"));
		}
		counter.setClist(remark);

		return counter;
	}

	
	public String  articleContent(int aid) throws SQLException {
		String sql = "select * from article where aid=" + aid;
		String content = null;
		String title=null;
		ResultSet rs = JDBCTool.executeQuery(sql);
		if (rs.next()) {
			content = rs.getString("content");
			title=rs.getString("title");
		}
		return content;
	}

	public String commentContent(int cid) throws SQLException {
		String sql = "select * from comment where cid=" + cid;
		String content = null;
		ResultSet rs = JDBCTool.executeQuery(sql);
		if (rs.next()) {
			content = rs.getString("content");
		}
		return content;
	}

}
