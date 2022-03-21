package com.programmfundamental;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
	System.out.println("Enter the number");
	int num=Integer.parseInt(scan.nextLine());
	for(int row=1;row<=num;row++) {     //print forward pattern 
		for(int column=1;column<=row;column++) {
			System.out.print(column+" ");
		}
		System.out.println();
	}
	
	for(int row=num;row>1;row--) {                //print reverse pattern 
		for(int column=1;column<=row;column++) {
			System.out.print(column+" ");
		}
		System.out.println();
	}
	}
}
