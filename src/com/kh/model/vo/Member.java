package com.kh.model.vo;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String SchoolName;
	private int age;
	private String email;
	
	public Member() {
		super();
	}


	public Member(int userNo, String userId, String userPwd, String SchoolName, int age, String email) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.SchoolName = SchoolName;
		this.age = age;
		this.email = email;
	}
	
	public Member(String userId, String userPwd, String SchoolName, int age, String email) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.SchoolName = SchoolName;
		this.age = age;
		this.email = email;
	}

	public int getUserNo() {
		return userNo;
	}
	
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getSchoolName() {
		return SchoolName;
	}


	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return userNo + ", " + userId + ", " + userPwd + ", " + SchoolName + ", " + age	+ ", " + email;
	}
}
