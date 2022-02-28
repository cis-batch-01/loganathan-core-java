package com.satsun.coursepartial;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseMain3 {

	public static void main(String[] args)  throws ParseException {
		//  Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of course :");
		int num=Integer.parseInt(scan.nextLine());
		List<Course3> courseList=new ArrayList<Course3>();        //create the array list
		System.out.println("Enter the courses:");
		for(int i=0;i<num;i++)
		{
		        String castData=scan.nextLine();
		       Course3 course=Course3.createCourse(castData); //String data parse throws  used

		  courseList.add(course);   //Course add in the  courselist
		  
		}
		System.out.format("%-15s%-20s%-10s%-6s\n", "title","Description","language","rating");
		for(Course3 course:courseList)  //foreach 
		{
			
			System.out.println(course);
			
			
		}
		System.out.println("top two course in the list");
		GetCourse courseA=new GetCourse();//another class object creation
		List<Course3> resList=courseA.findCourse(courseList);
		System.out.format("%-15s%-20s%-10s%-6s\n", "title","Description","language","rating");
		for(Course3 course :resList)     
		{
			System.out.println(course);
		}
		
			
	}

	

}
