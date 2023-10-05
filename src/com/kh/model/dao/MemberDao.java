package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.commom.JDBCTemplate;
import com.kh.model.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member m) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getSchoolName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getEmail());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public Member loginMember(Connection conn, String userId, String userpwd) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;

		String sql = "SELECT USERID, USERPWD FROM MEMBER WHERE USERID = ? AND USERPWD = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);
			pstmt.setString(2, userpwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "UPDATE MEMBER SET USERPWD = ?, AGE = ?, EMAIL = ? WHERE USERID = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getUserPwd());
			pstmt.setInt(2, m.getAge());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getUserId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int deleteMember(Connection conn, String userId, String userPwd) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "DELETE FROM MEMBER WHERE USERID = ? AND USERPWD = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
