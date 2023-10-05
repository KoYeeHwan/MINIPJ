package com.kh.view;

import java.util.Scanner;

import com.kh.controller.MemberController;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public void mainMenu() {

		while (true) {

			System.out.println("\n== 회원관리 프로그램");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 로그인");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("9. 프로그램 종료");

			System.out.print(">> 메뉴 선택 :");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				inputMember();
				break;
			case 2:
				loginMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 9 :
				System.out.println("포르그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private String inputMemberId() {
		return sc.nextLine();
	}

	public void inputMember() {
		System.out.println("\n=== 회원 추가 ===");

		System.out.print("아이디 :");
		String userId = sc.nextLine();

		System.out.print("비밀번호 :");
		String userPwd = sc.nextLine();

		System.out.print("학교 이름 :");
		String SchoolName = sc.nextLine();

		System.out.print("나이 :");
		String age = sc.nextLine();

		System.out.print("이메일 :");
		String email = sc.nextLine();

		mc.insertMember(userId, userPwd, SchoolName, age, email);
	}

	public void loginMember() {
		System.out.println("\n회원 아이디 입력 :");
		String userId = sc.next();

		System.out.println("\n회원 비밀번호 입력 : ");
		String userPwd = sc.next();

		mc.loginMember(userId, userPwd);
		return;
	}

	public void updateMember() {
		System.out.println("\n=== 회원 정보 변경 ===");

		System.out.println("아이디를 입력하세요 : ");
		String userId = inputMemberId();

		System.out.println("변경 할 비밀번호 : ");
		String userPwd = sc.nextLine();

		System.out.println("변경 할 나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("변경할 이메일 : ");
		String email = sc.nextLine();

		mc.updateMember(userId, userPwd, age, email);
		return;
	}

	private void deleteMember() {
		System.out.println("\n=== 회원 탈퇴 ===");

		System.out.println("아이디를 입력하세요 : ");
		String userId = sc.next();

		System.out.println("비밀번호를 입력하세요 : ");
		String userPwd = sc.next();

		mc.deleteMember(userId, userPwd);
		return;
	}

	// -------------------------- 응답화면 -----------------------------------
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}

	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
}
