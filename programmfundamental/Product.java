package com.programmfundamental;

import java.util.Scanner;

public class Product {
	static double Sbidiscount;
	static double icicidiscount;
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("1.sbi credit card\n2.icici credit card");
	char choice='n';
	do {
	System.out.println("Select any one  your offer");
	int offerSelect=Integer.parseInt(scan.nextLine());
	
	switch(offerSelect){
	case 1:
		Sbidiscount = ( 10* 10000) / 100;
		System.out.println("your discount amount is :"+Sbidiscount);
		System.out.println("your discount is 10% And total is 9000");
		break;
	case 2:
		icicidiscount =( 5* 10000) / 100;
		System.out.println("your discount amount is :"+icicidiscount);
		System.out.println("your discount is 5% And total is 9500");
		
		break;
	default:
		System.out.println("no offer");
		break;
		
	}System.out.println("Do you continue :");
	 choice=scan.nextLine().charAt(0);
}while(choice=='y');
}
}