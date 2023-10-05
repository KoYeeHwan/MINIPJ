package com.kh.model.vo;

public class Member {
	
	private int userNo;	 		// 회원번호
	private String userId;		// 회원 아이디
	private String userPwd;		// 회원 비밀번호
	private String SchoolName;	// 학교이름
	private int age;			// 나이
	private String email;		// 이메일
	
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
