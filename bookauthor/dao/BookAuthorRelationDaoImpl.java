package com.technocis.bookauthor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.technocis.bookauthor.connection.ConnectionUtil;

public class BookAuthorRelationDaoImpl implements BookAuthorRelationDao {
	private static final String INSERTRELATION = "insert into book_author (book_id,author_id) values(?,?)";
	public int insertBookAuthorRel(String book_id, String author_id) {
		Connection con = ConnectionUtil.getDBConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = con.prepareStatement(INSERTRELATION);
			pstmt.setString(1, book_id);
			pstmt.setString(2, author_id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return row;
	}

		
	}


