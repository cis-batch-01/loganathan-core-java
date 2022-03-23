package com.technocis.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.technocis.lmsmodel.Author;

public class AuthorTest {
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		char choice='n';
	do	{System.out.println("select any one\n1.insertAuthorDetails\n2.select AuthorDetails");
	int option=Integer.parseInt(scan.nextLine());
		switch(option) {
		case 1:
			try {
		System.out.println("Enter author details: ");
		System.out.println("This  author details to be enter( Author_name,about,new_book,address,lastbook_realeasedyear) ");
		
		String insertAuthorDetails=scan.nextLine();
		String data[]=insertAuthorDetails.split(",");
		Author insertAuthor;
		try {
			insertAuthor = new Author(data[0],data[1],data[2],data[3],sdf.parse(data[4]));
			Author insert=AuthorTest.insertAuthor(insertAuthor);
			System.out.println(insert!=null?"data is inserted\n"+insert:"data is  not inserted");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 2:
			try {
		System.out.println("Enter author id : ");
		int selectId=Integer.parseInt(scan.nextLine());
		Author author=AuthorTest.selectAuthor(selectId);
		System.out.println(author!=null?"data is showed\n"+author:"no data  found ");
		break;
		
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		} System.out.println("do you want continue");
		  choice=scan.nextLine().charAt(0);
	}  while(choice=='y');
	
	
	}
		static public Connection getDBConnect(){
		        Connection con=null;
				try{
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_manager","root","root");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return con;
		}
		static public Author insertAuthor(Author author){
			String insertquery="insert into author( Author_name,about,new_book,address,lastbook_realeasedyear)values(?,?,?,?,?)";
			Connection con=null;
			PreparedStatement pstmt=null;
			
			try{
				con=AuthorTest.getDBConnect();
				 pstmt=con.prepareStatement(insertquery);
				pstmt.setString(1,author.getAuthor_name());
			      pstmt.setString(2,author.getAbout());
				  pstmt.setString(3,author.getNew_book());
				  pstmt.setString(4,author.getAddress());
				  pstmt.setDate(5,(new java.sql.Date(author.getLastbook_realeasedyear().getTime())));
				  int insert= pstmt.executeUpdate();
				  if(insert>0){
					  return author;
				  }
			}catch(NumberFormatException e){
					e.printStackTrace();
				} catch (SQLException e) {
				e.printStackTrace();
			}finally {
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
	static public Author selectAuthor(int id) {
		String selectquery="select  Author_name,about,new_book,address,lastbook_realeasedyear from author where author_id =?";
		//"select topic_name,description,content,date from topic where topic_id=?";
		Connection con=null;
		Author author=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=AuthorTest.getDBConnect();
			pstmt=con.prepareStatement(selectquery);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				author	=new Author(id,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return author;
	}

}
	
