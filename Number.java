package com.technocis.sample;
import java.util.*;
public class Number {

	//int num1,num2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner(System.in);
         System.out.println("Enter the 1st num");
        int num1=sc.nextInt();
        System.out.println("Enter the 2nd num");
        int num2=sc.nextInt();
        
        if(num1>=num2) {
        	System.out.println("number 1 is greater");
        }
        else {
        	System.out.println("number 2 is greater ");
        }
	}

}
