package com.technocis.sample;
import java.util.*;
public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter the number");
  int num=scan.nextInt();
  
  if(num%2==0) {
	  
	  System.out.println("The number is Even");
	  
  }
  else {
	  System.out.println("The num is odd");
  }
	}

}
