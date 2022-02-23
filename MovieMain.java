package com.technocis.sample;

import java.util.Scanner;

public class MovieMain {

	public static void main(String[] args) {
		//  Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the 1 st movie :");
		String movie1=scan.nextLine();
		System.out.println("Enter the 2nd movie :");
		String movie2=scan.nextLine();
		
		
		//String[] str1 = "notes,2.00.000.0000,5.7,2.00.000.00";
        String[] data1 = movie1.split(",");
        Movie m1=new Movie(data1[0],Double.parseDouble(data1[1]),Double.parseDouble(data1[2]),Double.parseDouble(data1[3]));
		System.out.println("movie 1 :");
		System.out.println(movie1);
		
		String[] data2 = movie2.split(",");
        Movie m2=new Movie(data2[0],Double.parseDouble(data2[1]),Double.parseDouble(data2[2]),Double.parseDouble(data2[3]));
		System.out.println("movie 2 :");
		System.out.println(movie2);
		
	
		System.out.println(movie1.equals(movie2)?"Movie 1 and 2 are same" :"movie is diffrent");
	}

}
