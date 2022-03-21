package com.programmfundamental;

import java.util.Scanner;

public class Pattern {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
	System.out.println("Enter the number");
	int num=Integer.parseInt(scan.nextLine());
	for(int i=1;i<=num;i++) {
		for(int j=1;j<=i;j++) {
			System.out.print(j+" ");
		}
		System.out.println();
	}
	}
	}


