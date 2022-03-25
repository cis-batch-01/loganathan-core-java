package com.technocis.library.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.technocis.library.DAO.AuthorDAO;
import com.technocis.library.impl.AuthorDAOImpl;
import com.technocis.library.model.Author;

public class AuthorTest {
	public static  void  AuthorManager(){
		  Scanner scan=new Scanner(System.in);
		  SimpleDateFormat  sdf =new SimpleDateFormat("dd-MM-yyyy");
		  AuthorDAO authordao=new AuthorDAOImpl();
		  System.out.println("Author details");
		   char choice='n';
		   do{
		  System.out.println("1.get author\n2.getAll author\n3.add author\n4.update author\n5.delete author");
		  System.out.println("select any one");
		  int option=Integer.parseInt(scan.nextLine());
		  switch(option) {
		  case 1:
		   System.out.println("Enter the author id");
		   int selectId=Integer.parseInt(scan.nextLine());
		   Author author=authordao.getAuthor(selectId);
		   System.out.println(author!=null?"data is showed\n"+author:"no data");
		  break;
		  case 2:
		  List<Author> authorList=authordao.getAllAuthor();
		  if(authorList.isEmpty()) {
			  System.out.println("data is not found");
		  }else {
		  for(Author auth :authorList){
			  System.out.println(auth!=null?"data is showed\n"+auth:"no data");
		  }
		  }
		  break;
		  case 3:
		  System.out.println("Enter the Author details");
		   System.out.println("This  details to be enter (name,about,new_book,address,firstbook_releasedyear)");
		   String insert=scan.nextLine();
		   String data[]=insert.split(",");
			Author insertauthor;
			try {
				insertauthor = new Author(data[0],data[1],data[2],data[3],sdf.parse(data[4]));
				 Author insertData=authordao.addAuthor(insertauthor);
				    System.out.println(insertData!=null?"data is stored\n"+insertData:"no data stored");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		  break;
		  case 4:
			  System.out.println("Enter the update author id");
			   int updateId=Integer.parseInt(scan.nextLine());
			   Author oldData=authordao.getAuthor(updateId);
		   System.out.println(oldData + "\n updateauthor");  
		  System.out.println("Enter the Author details");
		   System.out.println("This  details to be enter (name,about,new_book,address,firstbook_releasedyear)");
		   String update=scan.nextLine();
		   String edit[]=update.split(",");
			try {
				Author updateauthor=new Author(edit[0],edit[1],edit[2],edit[3],sdf.parse(edit[4]));
				 Author updateData=authordao.updateAuthor(updateId, updateauthor);
				 System.out.println(updateData!=null?"data is updated\n"+updateData:"data is not updated");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  break;
		  case 5:
		  System.out.println("Enter the author id");
		   int Id=Integer.parseInt(scan.nextLine());
		   Author delete=authordao.deleteAuthor(Id);
		   System.out.println(delete!=null?"delete is success\n"+delete:"delete is not success");
		  break;
		  default:
		  System.out.println("invalid choice");
		  break;
		   }System.out.println("Do you want continue in author (y/n):");
		   choice =scan.nextLine().charAt(0);
		  } while(choice=='y'||choice=='Y');
		
		  
}
	}
