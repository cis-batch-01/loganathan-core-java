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
	static String getAuthour = "select name,gender,description,First_book_released_date from Author where author_id=? ";
	static String selectAllQuery = "select author_id,name,gender,description,First_book_released_date from Author ";
	static String addQuery = "insert into Author(author_id,name,gender,description,First_book_released_date)values(?,?,?,?,?)";
	static String selectbookAuthor="select a.Author_id,a.name,a.gender,a.description,a.First_book_released_date   from books "
			+ "join book_author on book_author.Book_id=books.Book_id "
			+ "join Author as a on book_author.Author_id=a.Author_id where book_author.Book_id=?";
	public Author insertAuthor(Author author) {
		Connection con =null;
		PreparedStatement pstmt;
		con=ConnectionUtil.getDBConnection();
		Books book =new Books();
		try {
			pstmt=con.prepareStatement(addQuery);
			pstmt.setString(1, author.getAuthor_id());
			pstmt.setString(2, author.getName());
			pstmt.setString(3, author.getGender());
			pstmt.setString(4, author.getDescription());
			pstmt.setDate(5,  new java.sql.Date(author.getFirstbook_releasedyear().getTime() ));
			int result=pstmt.executeUpdate();
			if(result>0) {
				
					BookAuthorRelationDao bookAuthorRelDao = new BookAuthorRelationDaoImpl();
					for (Author authordata : book.getAuthor()) {
						bookAuthorRelDao.insertBookAuthorRel(book.getBook_id(), author.getAuthor_id());

					}
					return author;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<Author> getAllAuthorBookList(String bookId) {
		List<Author> authorsList = new ArrayList<Author>();
		BooksDAO bookDao=new BooksDAOImpl();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBConnection();
			pstmt = con.prepareStatement(selectbookAuthor);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("execute");
				authorsList.add(
						new Author(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),bookDao.getAllAuthorBooks(bookId) ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return authorsList;
	}

	public List<Author> getAllAuthorList() {
		Connection con =null;
		PreparedStatement pstmt;
		Author author=null;
		 List<Author> resList= new ArrayList<Author>();
		 AuthorDAO authorDao=new AuthorDAOImpl();
		con=ConnectionUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement(selectAllQuery);
			ResultSet set=pstmt.executeQuery();
			while(set.next()) {
				resList.add(new Author(set.getString(1),set.getString(2),
						set.getString(3),set.getString(4),set.getDate(5))) ;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resList;
		
	}


	public Author getAuthor(String authorId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Author author = null;
		try {
			con = ConnectionUtil.getDBConnection();
			pstmt = con.prepareStatement(getAuthour);
			pstmt.setString(1, authorId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				author = new Author(authorId, rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), null);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return author;
	}
	

}
