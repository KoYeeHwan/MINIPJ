package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.model.vo.Board;
import com.kh.model.vo.Member;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	BoardController bc = new BoardController();

	public void BoardMenu(Member m) {

		while (true) {

			System.out.println("\n==계시판 관리 프로그램");
			System.out.println("1. 게시글 작성");
			System.out.println("2. 게시판 조회");
			System.out.println("3. 게시글 삭제");
			System.out.println("9. 로그아웃");

			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				writeBoard(m.getUserNo());
				break;
			case 2:
				selectBoardList(m.getUserNo());
				break;
			case 3:
				deleteBoard(m.getUserNo());
				break;
			case 9:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void writeBoard(int userNo) {

		System.out.print("제목을 입력하세요 :");
		String title = sc.nextLine();

		System.out.print("글을 작성해주세요 : ");
		String post = sc.nextLine();

		bc.writeBoard(userNo, title, post);
	}

	public void selectBoardList(int userNo) {

		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();

		bc.selectBoardList(title);
		return;
	}

	public void deleteBoard(int userNo) {
		System.out.println("\n=== 게시글 삭제 ===");

		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();

		bc.deleteBoard(userNo, title);
		return;
	}

	// --------------------- 응답화면 ------------------------
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}

	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}

	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}

	public void displayBoardList(ArrayList<Board> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다 \n");
		System.out.println("제목\t글\t작성일");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
