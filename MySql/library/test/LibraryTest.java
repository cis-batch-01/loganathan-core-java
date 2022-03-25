package com.technocis.library.test;

import java.util.Scanner;

public class LibraryTest {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		   System.out.println("Library Management");
		   char choice='n';
		   do{
		  System.out.println("1.Author details\n2.Supplier details ");
		  System.out.println("select any one");
		  int option=Integer.parseInt(scan.nextLine());
		  switch(option) {
		  case 1:
			  try {
		  AuthorTest.AuthorManager();
		  }catch(Exception e) {
			  e.getMessage();
		  }  
		  break;
		  case 2:
			  try { 
		  SupplierTest.SupplierManager();
		  }catch(Exception e) {
			  e.getMessage();
		  } 

		}System.out.println("Do you want continue in Supplier(y/n):");
		   choice =scan.nextLine().charAt(0);
		  } while(choice=='y'||choice=='Y');	
	}
		 
}
