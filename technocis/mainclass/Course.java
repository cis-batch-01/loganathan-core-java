package com.technocis.mainclass;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.technocis.LMS.CourseClass;
import com.technocis.Repo.Repository;
import com.technocis.impl.RepositoryImpl;

public class Course {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		Scanner scan=new Scanner(System.in);
		Repository co=new RepositoryImpl();
		System.out.println("course Details");
		
		char choice = 'n';
		do {
			System.out.println("1.Get all Course \n2.get course\n3.add course\n4.remove course\n5.update course");
			System.out.println("Select your choice");
			int option = Integer.parseInt(scan.nextLine());
			
			switch (option) {
			case 1:
				List<CourseClass> courseList = co.getAllCourseClass();
				System.out.println("Elemets from the Storage");
				if (!courseList.isEmpty()) {
					//System.out.format("%-15s%-16s%-16s%-15s%-15s%-15s\n", "courseId", "courseName", "courseContent","skillLevel","duration","rating");
					for (CourseClass course : courseList) 
					{
						System.out.println(course); 
					}
				}
				else
				{
					System.out.println("the  list is empty");
				}
				break;
			case 2:
				System.out.println("Enter the course id:");
				int courseid = Integer.parseInt(scan.nextLine());
		           CourseClass topic = co.get(courseid);
		           System.out.format("%-15s%-16s%-16s%-15s%-15s%-15s\n", "courseId", "courseName", "courseContent","skillLevel","duration","rating");
				System.out.println(topic!=null?topic:"id not found");
				break;
			case 3:
				System.out.println("Enter the topic Details");
				String data = scan.nextLine();
			CourseClass courseNew = CourseClass.createCourseClass(data);
				boolean res=co.addCourseClass(courseNew);
				System.out.println(res?"Topic Added successfully":"storage is full");//ternary operation
				break;
			case 4:
				System.out.println("Enter the id to be removed");
				int removeid=Integer.parseInt(scan.nextLine());
				System.out.println(co.remove(removeid)?"Removed successfully":"not removed");
				break;
			case 5:
				System.out.println("Enter the id to be updated:");
				int updateId=Integer.parseInt(scan.nextLine()); //input for id number
				System.out.println("Enter the course details");
				String updateData=scan.nextLine();                //input for updated data
			CourseClass updatedCourseClass=CourseClass.createCourseClass(updateData);
			boolean result=co.updateCourseClass(updateId, updatedCourseClass);
				System.out.println(result?"updated":"not get updated");
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue (y/n)");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y');

	}

}
