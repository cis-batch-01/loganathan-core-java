package com.technocis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Company {
	public static void main(String[] args) {
		InputStreamReader iSR = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(iSR);
		System.out.println(" Enter the no .of element :");
		System.out.println("First enter the year and profit");
		int number = 0;
		try {
			number = Integer.parseInt(br.readLine());
			if (number > 1) {
				int detail[] = new int[number];
				System.out.println("enter the year and profit");
				for (int index = 0; index < detail.length; index++) {
					detail[index] = Integer.parseInt(br.readLine());
				}
				int result = 0;
				int resultindex = 0;
				System.out.println(Arrays.toString(detail));
				for (int index = 0; index < detail.length; index++) { // to find maximum number
					if (detail[index] > result) {
						result = detail[index];
						resultindex = index;
					}
				}
				System.out.println("Maximum profit value is" + result);
				System.out.println(detail[resultindex - 1]); // to index value -1
			} else {
				System.out.println("invalid input");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}