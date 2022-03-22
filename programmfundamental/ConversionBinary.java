package com.technocis;

import java.util.Scanner;

public class ConversionBinary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the  postive number :");
		int num = Integer.parseInt(scan.nextLine());
		if (num > 0) {
			System.out.println("The Integer value is :" + num);
			System.out.println("The Binary value is :" + Integer.toBinaryString(num));
		} else {
			System.out.println("Invalid input ");
			System.exit(0);
		}
	}
}
