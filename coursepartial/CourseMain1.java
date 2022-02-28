package com.satsun.coursepartial;

import java.text.ParseException;
import java.util.Scanner;



public class CourseMain1 {

	public static void main(String[] args) throws NumberFormatException, ParseException{
		//  Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("Enter the course1 details :");
 String course1=scan.nextLine();

String[] data1 =course1.split(",");
 Course1 c1=new Course1(data1[0],data1[1],data1[2],Double.parseDouble(data1[3]));
	//System.out.println("");
	

	System.out.println("Enter the course2 details :");
	 String course2=scan.nextLine();

	String[] data2 =course2.split(",");
	 Course1 c2=new Course1(data2[0],data2[1],data2[2],Double.parseDouble(data2[3]));
		//System.out.println("");
	 System.out.println("course1 :");
	 System.out.println(c1);
	 System.out.println("course2 :");
		System.out.println(c2);
		System.out.println(course1.equals(course2)?"course 1 and 2 are same" :"course is diffrent");
	}

}
