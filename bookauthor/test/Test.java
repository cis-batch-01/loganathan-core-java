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


public class Test {
	
		public static  void  main(String args[]){
			  Scanner scan=new Scanner(System.in);
			  SimpleDateFormat  sdf =new SimpleDateFormat("dd-MM-yyyy");
			  AuthorDAO authordao=new AuthorDAOImpl();
			  BooksDAO book=new BooksDAOImpl();
			  System.out.println("Author details");
			   char choice='n';
			   do{
			  System.out.println("1.getAll author\n2.add author");
			  System.out.println("select any one");
			  int option=Integer.parseInt(scan.nextLine());
			  switch(option) {
			  
			  case 1:
			  List<Author> authorList=authordao.getAllAuthor();
			  if(authorList.isEmpty()) {
				  System.out.println("data is not found");
			  }else {
			  for(Author auth :authorList){
				  System.out.println(auth!=null?"data is showed\n"+auth:"no data");
			  }
			  }
			  break;
			  case 2:
			  System.out.println("Enter the Author details");
			   System.out.println("This  details to be enter ( name,gender,description,firstbook_releasedyear)");
			   String insert=scan.nextLine();
			   String data[]=insert.split(",");
				Author insertauthor;
				try {
					insertauthor = new Author(data[0],data[1],data[2],data[3],sdf.parse(data[4]),null);
					 Author insertData=authordao.insertAuthor(insertauthor);
					    System.out.println(insertData!=null?"data is stored\n"+insertData:"no data stored");
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
			  
			  break;
			  
			  
			  default:
			  System.out.println("invalid choice");
			  break;
			   }System.out.println("Do you want continue in author (y/n):");
			   choice =scan.nextLine().charAt(0);
			  } while(choice=='y'||choice=='Y');
			
			  
	}
	}


