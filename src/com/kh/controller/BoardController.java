package com.kh.controller;

import com.kh.view.BoardMenu;

import java.util.ArrayList;

import com.kh.model.dao.BoardDao;
import com.kh.model.service.BoardService;
import com.kh.model.vo.Board;

public class BoardController {

	public void writeBoard(int userNo, String title, String post) {

		Board b = new Board(title, post);
		System.out.println(b);

		int result = new BoardService().writeBoard(userNo, b);

		if (result > 0) {
			new BoardMenu().displaySuccess("글이 작성되었습니다.");
		} else {
			new BoardMenu().displayFail("글 작성에 실패 하였습니다.");
		}
	}

	public void selectBoardList(String title) {
		ArrayList<Board> list = new BoardService().selectBoardList(title);

		if (list.isEmpty()) {
			new BoardMenu().displayNoData("전체 조회 결과가 없습니다.");
		} else {
			new BoardMenu().displayBoardList(list);
		}
	}

	public void deleteBoard(int userNo, String title) {
		int result = new BoardService().deleteBoard(userNo, title);

		if (result > 0) {
			new BoardMenu().displaySuccess("성공적으로 글이 삭제 되었습니다.");
		} else {
			new BoardMenu().displayFail("글 삭제에 실패 하였습니다.");
		}
	}
}
