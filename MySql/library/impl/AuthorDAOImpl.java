package com.technocis.library.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocis.library.DAO.AuthorDAO;
import com.technocis.library.model.Author;

public class AuthorDAOImpl implements AuthorDAO {

	static String selectQuery = "select Author_Name,about,new_book,address,firstbook_releasedyear from author where author_id=?";
	static String selectAllQuery = "select Author_Name,about,new_book,address,firstbook_releasedyear from author";
	static String addQuery = "insert into author(Author_Name,about,new_book,address,firstbook_releasedyear)values(?,?,?,?,?)";
	static String updateQuery = "update author set Author_Name=?,about=?,new_book=?,address=?,firstbook_releasedyear=? where author_id=?";
	static String deleteQuery = "delete from author where author_id=?";

	public Author getAuthor(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Author author = null;
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				author = new Author(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return author;
	}

	public List<Author> getAllAuthor() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Author> authorList = new ArrayList<Author>();
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(selectAllQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				authorList.add(
						new Author(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return authorList;
	}

	public Author addAuthor(Author author) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(addQuery);
			pstmt.setString(1, author.getAuthor_Name());
			pstmt.setString(2, author.getAbout());
			pstmt.setString(3, author.getNewbook());
			pstmt.setString(4, author.getAddress());
			pstmt.setDate(5, (new java.sql.Date(author.getFirstbook_releasedyear().getTime())));
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return author;
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return null;
	}

	public Author updateAuthor(int id, Author author) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, author.getAuthor_Name());
			pstmt.setString(2, author.getAbout());
			pstmt.setString(3, author.getNewbook());
			pstmt.setString(4, author.getAddress());
			pstmt.setDate(5, (new java.sql.Date(author.getFirstbook_releasedyear().getTime())));
			pstmt.setInt(6, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return author;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return null;
	}

	public Author deleteAuthor(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Author author = getAuthor(id);
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return author;
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return null;
	}
}
