package com.kh.view;

import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.member.Member;

public class BoardMenu {
	private Scanner sc = new Scanner(System.in);
	private BoardController bc = new BoardController();
	
	
	public void mainMenu(com.kh.model.vo.Member b) {
		
		while(true) {
			
			System.out.println("\n==계시판 관리 프로그램");
			System.out.println("1. 게시글 작성");
			System.out.println("2. 게시판 조회");
			System.out.println("3. 게시글 삭제");
			System.out.println("9. 프로그램 종료");
			
			System.out.print(">> 메뉴 선택");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				writePost(b.getUserNo());
				break;
			case 2:
				selectBoard();
				break;
			case 3:
				deletePost();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;	
			default :
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
			}			
		}
	}
	
	public void writePost() {
		System.out.println("제목을 입력하세요");	
		
	}	
	
	public void selectBoard() {
		
	}
	
	public void deletePost() {
		
	}
}
