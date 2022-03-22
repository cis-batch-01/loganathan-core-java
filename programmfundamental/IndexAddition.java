package com.technocis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IndexAddition {
	public static void main(String[] args) {
		InputStreamReader iSR = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(iSR);
		System.out.println(" Enter the no .of element :");
		int number = 0;
		try {
			number = Integer.parseInt(br.readLine());
			if (number > 0) {
				int detail[] = new int[number];
				System.out.println("enter the year and profit");
				for (int index = 0; index < detail.length; index++) {
					detail[index] = Integer.parseInt(br.readLine());
					if (detail[index] < 0) {
						System.out.println("Should be positive value");
						System.exit(0);
					}
				}
				System.out.println(Arrays.toString(detail));
				int result = 0;
				for (int index = 0; index < detail.length; index++) {
					if (index % 2 == 0) {
						result = result + detail[index];
					}
				}
				System.out.println("The even index sum is :"+result);
			} else {
				System.out.println("Invalid data");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
