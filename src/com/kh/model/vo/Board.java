package com.kh.model.vo;

import java.sql.Date;

public class Board {

	private int postNo; // 게시글 번호
	private String title; // 게시글 제목
	private int userNo; // 회원번호
	private String post; // 게시글
	private Date postDate; // 게시글 작성일

	public Board() {
		super();
	}

	public Board(int postNo, String title, int userNo, String post, Date postDate) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.post = post;
		this.postDate = postDate;
	}

	public Board(int postNo, String title, String post) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.post = post;
	}

	public Board(String title, String post) {
		super();
		this.title = title;
		this.post = post;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getUserNo() {
		return userNo;
	}
	
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return title + '\t' + post + '\t' + postDate;
	}

}
