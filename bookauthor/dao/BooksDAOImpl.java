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


public class BooksDAOImpl implements  BooksDAO{

	static String selectAllQuery = "select Name,description,Publication,Published_date,Price from Books where Book_id=?";
	static String addQuery = "insert into Books( Book_id,Name,description,Publication,Published_date,Price)values(?,?,?,?,?)";
	static String selectAuthorBook=" select  books.title,books.description, books.price from books "
			+ "join book_author on book_author.Book_id=books.Book_id join Author  as a on book_author.Author_id=a.Author_id "
			+ "where book_author.Author_id=?";
			
	public Books insertBooks(Books book) {
		Connection con =null;
		PreparedStatement pstmt;
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(addQuery);
			pstmt.setString(1, book.getBook_id());
			pstmt.setString(2, book.getName());
			pstmt.setString(3, book.getDescription());
			pstmt.setString(4, book.getPublication());
			pstmt.setDate(5,  new java.sql.Date(book.getPublished_date().getTime() ));
			pstmt.setDouble(6, book.getPrice());
			int result=pstmt.executeUpdate();
			if(result>0) {
				return book;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Books> getAllBooks(String bookId) {
		Connection con =null;
		PreparedStatement pstmt;
		List<Books> resList=new ArrayList<Books>();
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(selectAllQuery);
			pstmt.setString(1, bookId);
			ResultSet set=pstmt.executeQuery();
			while(set.next()) {
				resList.add(new Books(set.getString(1),set.getString(2),
						set.getString(3),set.getString(4),set.getDate(5),set.getDouble(6),null)) ;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resList;
	}
	public List<Author> getAllAuthorBooks(String authorId) {
		Connection con =null;
		PreparedStatement pstmt;
		Author author=null;
		 List<Author> resList= new ArrayList<Author>();
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(selectAuthorBook);
			pstmt.setString(1,authorId);
			ResultSet set=pstmt.executeQuery();
			while(set.next()) {
				resList.add(new Author(set.getString(1),set.getString(2),
						set.getString(3),set.getString(4),set.getDate(5),null)) ;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resList;
	}

}
