package com.neuesoft.blog.pojo;

import java.util.ArrayList;

public class Article_Edit {
	private Article article=new Article();
	private ArrayList<Category> catelist=new ArrayList<Category>();
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public ArrayList<Category> getCatelist() {
		return catelist;
	}
	public void setCatelist(ArrayList<Category> catelist) {
		this.catelist = catelist;
	}


}
