package com.technocis.sample;
import java.util.*;
public class Arraysample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Scanner scan =new Scanner(System.in); 
  System.out.println("Enter the no.of element :");
  int num = Integer.parseInt(scan.nextLine());
  String strarray []=new String[num];
  System.out.println("Enter the element one by one :");
   for(int i=0;i<strarray.length;i++)
   { 
	   strarray[i]= scan.nextLine();  
   }
  System.out.println("Enter the string");
  String str=scan.nextLine();
  for(int i=0;i<strarray.length;i++) {
	
	  if(str.equals(strarray[i])) {
		  System.out.println("index "+i);
		  break;
	  }
	  
	  
  }
  
  
  
	}

}
