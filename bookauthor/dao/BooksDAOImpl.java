package com.technocis.bookauthor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocis.bookauthor.connection.ConnectionUtil;
import com.technocis.bookauthor.model.Author;
import com.technocis.bookauthor.model.Books;

public class BooksDAOImpl implements BooksDAO {

	static String selectAllQuery = "select book_id,title,description,Publication,Published_date,Price from books ";
	static String addQuery = "insert into books( Book_id,title,description,Publication,Published_date,Price)values(?,?,?,?,?,?)";
	static String selectAuthorBook = " select  books.Book_id,books.title,books.description,books.publication,books.published_date,books.price from books "
			+ "join book_author on book_author.Book_id=books.Book_id join Author  as a on book_author.Author_id=a.Author_id "
			+ "where book_author.Author_id=?";

	public Books insertBooks(Books book) {
		Connection con = null;
		PreparedStatement pstmt=null;
		con = ConnectionUtil.getDBConnection();
		try {
			pstmt = con.prepareStatement(addQuery);
			pstmt.setString(1, book.getBook_id());
			pstmt.setString(2, book.getName());
			pstmt.setString(3, book.getDescription());
			pstmt.setString(4, book.getPublication());
			pstmt.setDate(5, new java.sql.Date(book.getPublished_date().getTime()));
			pstmt.setDouble(6, book.getPrice());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				BookAuthorRelationDao bookAuthorRelDao = new BookAuthorRelationDaoImpl();
				for (Author author : book.getAuthor()) {
					
					bookAuthorRelDao.insertBookAuthorRel(book.getBook_id(), author.getAuthor_id());

				}
				return book;
			}
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
		return null;
	}

		public List<Books> getAllBooks() {
		AuthorDAO authorDao = new AuthorDAOImpl();
		List<Books> bookList = new ArrayList<Books>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBConnection();
			pstmt = con.prepareStatement(selectAllQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bookList.add(new Books(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getDouble(6), authorDao.getAllAuthorBookList(rs.getString(1))));
			}

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
		return bookList;
	}

	public List<Books> getAllAuthorBooks(String authorId) {
		List<Books> listOfBooks = new ArrayList<Books>();
		AuthorDAO authorDao = new AuthorDAOImpl();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = ConnectionUtil.getDBConnection();
		try {
			pstmt = con.prepareStatement(selectAuthorBook);
			pstmt.setString(1, authorId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				listOfBooks.add(new Books(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getDouble(6),null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfBooks;
	}
}
