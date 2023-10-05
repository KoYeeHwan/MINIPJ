package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.commom.JDBCTemplate;
import com.kh.model.dao.BoardDao;
import com.kh.model.vo.Board;

public class BoardService {

	public int writeBoard(int userNo, Board b) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().writeBoard(conn, userNo, b);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public ArrayList<Board> selectBoardList(String title) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectBoardList(conn, title);

		JDBCTemplate.close(conn);

		return list;
	}

	public int deleteBoard(int userNo, String title) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().deleteBoard(conn, userNo, title);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}
}
