package com.neuesoft.blog.pojo;

import java.util.ArrayList;

public class ShowArticle {
	private Article article=new Article();
	private ArrayList<String> categorylist=new ArrayList<String>();
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public ArrayList<String> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(ArrayList<String> categorylist) {
		this.categorylist = categorylist;
	}
}
