package com.technocis.sample;
import java.util.*;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Scanner scan=new Scanner(System.in);
 System.out.println("Enter the number = ");
 int num=scan.nextInt();
 int fact=1;
 
 for(int i=1;i<=num;i++) 
 {
	 fact=fact*i;
	 
 }
 System.out.println("fact num is:"+fact );
		 
	}

}
