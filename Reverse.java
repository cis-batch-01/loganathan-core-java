package com.technocis.sample;
import java.util.*;
public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the String :");
           String str=sc.nextLine();
//  		StringBuilder sb=new StringBuilder();   //use to the reverse in the string
// 		String rev=sb.reverse().toString();
//       	System.out.println(rev);

           String rev="";
 	      int length = str.length();           
 	      for ( int i = length - 1; i >= 0; i-- )  
 	      {
 	         rev = rev + str.charAt(i);
 	      }
 	      
 	      System.out.println(rev);
	}

}
