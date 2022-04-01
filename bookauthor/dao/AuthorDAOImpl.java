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

public class AuthorDAOImpl implements AuthorDAO{
	
	static String selectAllQuery = "select author_id,name,gender,description,First_book_released_date from Author ";
	static String addQuery = "insert into author( name,gender,description,First_1"
			+ "book_released_date)values(?,?,?,?,?)";
	static String selectbookAuthor="select a.name,a.gender,a.description,a.First_book_released_date  from books "
			+ "join book_author on book_author.Book_id=books.Book_id "
			+ "join Author as a on book_author.Author_id=a.Author_id where book_author.Book_id=?";
	public Author insertAuthor(Author author) {
		Connection con =null;
		PreparedStatement pstmt;
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(addQuery);
			pstmt.setString(1, author.getAuthor_id());
			pstmt.setString(2, author.getName());
			pstmt.setString(3, author.getGender());
			pstmt.setString(4, author.getDescription());
			pstmt.setDate(5,  new java.sql.Date(author.getFirstbook_releasedyear().getTime() ));
			int result=pstmt.executeUpdate();
			if(result>0) {
				return author;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<Author> getAllAuthor(String bookId) {
		Connection con =null;
		PreparedStatement pstmt;
		Author author=null;
		 List<Author> resList1= new ArrayList<Author>();
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(selectbookAuthor);
			pstmt.setString(1,bookId);
			ResultSet set=pstmt.executeQuery();
			while(set.next()) {
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resList1;
	}
	public List<Author> getAllAuthor() {
		Connection con =null;
		PreparedStatement pstmt;
		Author author=null;
		 List<Author> resList= new ArrayList<Author>();
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(selectAllQuery);
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
