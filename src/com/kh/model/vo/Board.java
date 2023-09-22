package com.kh.model.vo;

import java.sql.Date;

public class Board {
	
	private int postNo;
	private String category;
	private Date postDate;
	
	public Board() {
		super();
	}
	
	public Board(int postNo, String category, Date postDate) {
		super();
		this.postNo = postNo;
		this.category = category;
		this.postDate = postDate;
	}
	
	public Board(int postNo, String category) {
		super();
		this.postNo = postNo;
		this.category = category;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return postNo + "," + category + "," + postDate;
	}
	
	
}
