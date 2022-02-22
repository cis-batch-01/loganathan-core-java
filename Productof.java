package com.technocis.sample;

import java.util.Scanner;

public class Productof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("Enter the number of element");
  int num=Integer.parseInt(scan.nextLine());
  int [] res=new int [num];
  System.out.println("Element one by one");
   for(int i=0;i<num;i++)
   {
	  res[i]= Integer.parseInt(scan.nextLine());
	   
   }
   int multi=1;
   for(int i=0;i<num;i++){
	   
	   multi=multi*res[i];
	   
	   
   }
   System.out.println("Multiplay num is"+multi);
   }
   }

	


