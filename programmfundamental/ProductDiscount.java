package com.programmfundamental;

import java.util.Scanner;

public class ProductDiscount {
	
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	double discount=0;
	System.out.println("1.sbi credit card\n2.icici credit card");
	double price=0;
	System.out.println("Select any one  your offer");
	int offerSelect=Integer.parseInt(scan.nextLine());
	switch(offerSelect){
	case 1:
		System.out.println("Enter the product price ");
		price =Integer.parseInt(scan.nextLine());
		discount = ( 10*  price) / 100;
		price=price-discount;
		break;
	case 2:
		System.out.println("Enter the product price ");
	price =Integer.parseInt(scan.nextLine());
		discount =( 5* price) / 100;
		price=price-discount;
		
		break;
	default:
		System.out.println("no offer");
		break;
		
	}
	if(discount>0)
	{
		System.out.println("your discount amount is :"+discount);	
		System.out.println("Your Total Amount:"+price);
	}
}
}


