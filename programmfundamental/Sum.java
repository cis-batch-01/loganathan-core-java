package com.programmfundamental;

import java.util.Arrays;
import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the no.of element");
		int num=Integer.parseInt(scan.nextLine());
		int []number=new int[num];
		System.out.println("Enter  the  number one by one :");
for(int i=0;i<number.length;i++) {
	
	number[i]=Integer.parseInt(scan.nextLine());
}
		System.out.println(Arrays.toString(number));
		Arrays.sort(number);
		int result=0;
	for(int i=number.length-1;i>=number.length-3;i--) {
		
		result=result+number[i];
		
	}
	System.out.println("Sum of largest three value  is :"+result);
}
}