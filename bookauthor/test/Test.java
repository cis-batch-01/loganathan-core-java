package com.technocis.bookauthor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.technocis.bookauthor.connection.ConnectionUtil;
import com.technocis.bookauthor.dao.AuthorDAO;
import com.technocis.bookauthor.dao.AuthorDAOImpl;
import com.technocis.bookauthor.dao.BooksDAO;
import com.technocis.bookauthor.dao.BooksDAOImpl;
import com.technocis.bookauthor.model.Author;
import com.technocis.bookauthor.model.Books;


public class Test {
	
		public static  void  main(String args[]){
			  Scanner scan=new Scanner(System.in);
			  SimpleDateFormat  sdf =new SimpleDateFormat("dd-MM-yyyy");
			  AuthorDAO authorDao=new AuthorDAOImpl();
			  BooksDAO bookDao=new BooksDAOImpl();
			  System.out.println("Author details");
			   char choice='n';
			   do{
			  System.out.println("1.add book\n2.add author");
			  System.out.println("select any one");
			  int option=Integer.parseInt(scan.nextLine());
			  switch(option) {
			  
			  case 1:
				  System.out.println("Enter the book details");
				   System.out.println("This  details to be enter ( Book_id,Name,description,Publication,Published_date,Price)");
				   String insertBook=scan.nextLine();
				   String data[]=insertBook.split(",");
					
					try {
						Books books = new Books(data[0],data[1],data[2],data[3],sdf.parse(data[4]),Double.parseDouble(data[5]),null);
						Books insertBookData=bookDao.insertBooks(books);
						    System.out.println(insertBookData!=null?"data is stored\n"+insertBookData:"no data stored");
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
				  
			  break;
			  case 2:
			  System.out.println("Enter the Author details");
			   System.out.println("This  details to be enter ( author_id,name,gender,description,First_book_released_date)");
			   String insert=scan.nextLine();
			   String authorData[]=insert.split(",");
				Author insertauthor;
				try {
					insertauthor = new Author(authorData[0],authorData[1],authorData[2],authorData[3],sdf.parse(authorData[4]),null);
					 Author insertAuthorData=authorDao.insertAuthor(insertauthor);
					    System.out.println(insertAuthorData!=null?"data is stored\n"+insertAuthorData:"no data stored");
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
			  
			  break;
			  
			  
			  default:
			  System.out.println("invalid choice");
			  break;
			   }System.out.println("Do you want continue  (y/n):");
			   choice =scan.nextLine().charAt(0);
			  } while(choice=='y'||choice=='Y');
			
			  
	}
	}


