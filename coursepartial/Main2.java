package com.satsun.coursepartial;

import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;




public class Main2 {

	public static void main(String[] args) throws ParseException {
		//  Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("Enter the number of course :");
int num=Integer.parseInt(scan.nextLine());
List<Course2> courseList=new ArrayList<Course2>();
System.out.println("Enter the courses:");
for(int i=0;i<num;i++)
{
        String castData=scan.nextLine();
       Course2 course=Course2.createCourse(castData); //

  courseList.add(course);
  
}
System.out.format("%-15s%-20s%-10s%-6s\n", "title","Description","language","rating");
for(Course2 course:courseList)
{
	
	System.out.println(course);
	
}
System.out.println("Enter the Search Type:\n1.Title\n2.Rating"); //select the user choice
 int choice=Integer.parseInt(scan.nextLine());
switch(choice)
{
case 1:
	System.out.println("Enter the Title:"); //press 1 to select the title search
	String title=scan.nextLine();
	CourseBo1 courseA=new CourseBo1();      //to create the object for another class
	List<Course2> resList=courseA.findCast(courseList, title);
	System.out.format("%-15s%-20s%-10s%-6s\n", "title","Description","language","rating");
	for(Course2 course:resList)
	{
		
		System.out.println(course);
		
	}
	break;

case 2:
	
	System.out.println("Enter the Rating :");
	double rating=Double.parseDouble(scan.nextLine());	
	CourseBo1 courseB=new CourseBo1();   
	List<Course2> resList1=courseB.findCast(courseList, rating); //
	System.out.format("%-15s%-20s%-10s%-6s\n", "title","Description","language","rating");
	for(Course2 course:resList1)
	{
		
		System.out.println(course);
		
	}
	
	break;
	default:
		System.out.println("Invalid input");
}

	}

}

