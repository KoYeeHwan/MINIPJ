package com.kh.controller;

import com.kh.model.dao.MemberDao;
import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {

	public void insertMember(String userId, String userPwd, String SchoolName, String age, String email) {

		Member m = new Member(userId, userPwd, SchoolName, Integer.parseInt(age), email);
		System.out.println(m);

		int result = new MemberService().insertMember(m);

		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원이 생성 되었습니다.");
		} else {
			new MemberMenu().displayFail("회원 생성에 실패 하였습니다.");
		}
	}
	
	public void loginMember(String userId, String userPwd) {
		int result = new MemberService().loginMember(userId, userPwd);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("로그인에 성공하였습니다.");
		} else {
			new MemberMenu().displayFail("로그인에 실패하였습니다.");
		}
		
	}

	public void updateMember(String userId, String userPwd, int age, String email) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setAge(age);
		m.setEmail(email);
		
		int result = new MemberService().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보가 변경 되었습니다.");
		} else {
			new MemberMenu().displayFail("회원 정보 변경에 실패 하였습니다");
		}
	} 
	
	public void deleteMember(String userId) {
		int result = new MemberService().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 탈퇴처리 하였습니다");
		} else {
			new MemberMenu().displayFail("회원 탈퇴에 실패 하였습니다.");
		}
	}
}
