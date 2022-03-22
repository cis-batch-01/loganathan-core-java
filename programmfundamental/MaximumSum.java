package com.technocis;

import java.util.Scanner;

public class MaximumSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no.of element");
		int num = Integer.parseInt(scan.nextLine());
		int[] number = new int[num];
		int resultE = 0;
		int resultO = 0;
		System.out.println("Enter  the  number one by one :");
		for (int index = 0; index < number.length; index++) {
			number[index] = Integer.parseInt(scan.nextLine());
		}
		for (int index = 0; index < number.length; index++) {
			if (number[index] % 2 == 0) {
				resultE = resultE + number[index];
			} else {
				resultO = resultO + number[index];
			}
		}
		if(resultE>resultO) {
			System.out.println("The sum of  odd number is :" + resultO);
		}else {
			System.out.println("the even number is :" + resultE);
}
	}
}
