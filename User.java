package com.technocis.sample;
import java.util.*;
public class User {
	
	public static void main(String[] args) {
		
	
Scanner scan=new Scanner(System.in);
//int num =scan.nextInt();
int num;
do{
	System.out.println("Enter the Number : ");
	num=Integer.parseInt(scan.nextLine());
	if(num<=0){
		System.out.println("Invaild input");
	}
	
}while(num<=0);

	}
	
	
}
