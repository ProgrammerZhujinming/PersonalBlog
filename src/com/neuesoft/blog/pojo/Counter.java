package com.neuesoft.blog.pojo;

import java.util.ArrayList;

public class Counter {
	private int acounts;
	private int ccounts;
	private int fcounts;
	private ArrayList<Article> alist = new ArrayList<Article>();
	private ArrayList<Remark> clist = new ArrayList<Remark>();
	public Counter(){
		
	}
	public ArrayList<Remark> getClist() {
		return clist;
	}
	public void setClist(Remark clist) {
		this.clist.add(clist);
	}
	public ArrayList<Article> getAlist() {
		return alist;
	}
	public void setAlist(Article alist) {
		this.alist.add(alist);
	}
	public int getAcounts() {
		return acounts;
	}
	public void setAcounts(int acounts) {
		this.acounts = acounts;
	}
	public int getCcounts() {
		return ccounts;
	}
	public void setCcounts(int ccounts) {
		this.ccounts = ccounts;
	}
	public int getFcounts() {
		return fcounts;
	}
	public void setFcounts(int fcounts) {
		this.fcounts = fcounts;
	}
	
}
