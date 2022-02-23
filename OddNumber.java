package com.technocis.sample;

import java.util.Scanner;

public class OddNumber {

	public static void main(String[] args) {
		// Auto-generated method stub
    Scanner scan=new Scanner(System.in);
    System.out.println("Enetr the no.of Element :");
    int num=Integer.parseInt(scan.nextLine());
	 int intArray[]= new int[num]; 
	 System.out.println("Enter the numbers one by one");
	 for(int i=0;i<num;i++)
		{
			intArray[i]=Integer.parseInt(scan.nextLine());
		}
	
	 int sum=0;
	  
	  for(int i=0;i<intArray.length;i++)
	  {
		  
		  if(i%2!=0) {
			  sum+=intArray[i];
		  }
		  }
		  
		  System.out.println("the odd number is :"+sum);
	  }
	  
	}
	


