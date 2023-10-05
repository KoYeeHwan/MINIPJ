package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.commom.JDBCTemplate;
import com.kh.model.vo.Board;

public class BoardDao {

	public int writeBoard(Connection conn, int userNo, Board b) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD VALUES(SEQ_POSTNO.NEXTVAL,?,?,?,SYSDATE)";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getPost());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectBoardList(Connection conn, String title) {

		ArrayList<Board> list = new ArrayList<Board>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM BOARD WHERE TITLE = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Board b = new Board();
				b.setTitle(rset.getString("title"));
				b.setPost(rset.getString("post"));
				b.setPostDate(rset.getDate("postdate"));

				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteBoard(Connection conn, int userNo, String title) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "DELETE FROM BOARD WHERE USERNO = ? AND TITLE = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setString(2, title);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
