package com.technocis.main;

import java.awt.print.Printable;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.technocis.impl.RepositoryImpl;
import com.technocis.lms.CourseClass;
import com.technocis.rating.GetCourse;
import com.technocis.repo.Repository;

public class Course {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		Scanner scan = new Scanner(System.in);
		Repository co = new RepositoryImpl();
		System.out.println("course Details");
		List<CourseClass> courseList = null;
		GetCourse pcourse = new GetCourse();
		char choice = 'n';
		do {
			System.out.println(
					"1.Get all Course \n2.get course from id \n3.add course\n4.remove course\n5.update course\n6.good rating courses"
							+ "               \n7.poor rating courses\n8.Area of interest");
			System.out.println("Select your choice");
			int option = Integer.parseInt(scan.nextLine());

			switch (option) {
			case 1:
				courseList = co.getAllCourseClass();
				System.out.println("Elemets from the Storage");
				if (!courseList.isEmpty()) {
					System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
							"skillLevel", "duration", "rating");
					for (CourseClass course : courseList) {
						System.out.println(course);
					}
				} else {
					System.out.println("the  list is empty");
				}
				break;
			case 2:
				System.out.println("Enter the course id:");
				int courseid = Integer.parseInt(scan.nextLine());
				CourseClass topic = co.get(courseid);
				try {
					if (topic == null) {
						throw new CourseNotFoundException("check  your id");
					} else {
						System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
								"skillLevel", "duration", "rating");
						System.out.println(topic != null ? topic : "id not found");

					}
				} catch (Exception e) {

					System.out.println(e);

				}

				
				break;
			case 3:
				System.out.println(
						"This details are enter the user ( courseId, courseName, courseContent,skillLevel,duration,rating)");
				System.out.println("Enter the topic Details");
				String data = scan.nextLine();
				CourseClass courseNew = CourseClass.createCourseClass(data);
				boolean res = co.addCourseClass(courseNew);
				System.out.println(res ? "Topic Added successfully" : "storage is full");// ternary operation
				break;
			case 4:
				System.out.println("Enter the id to be removed");
				int removeid = Integer.parseInt(scan.nextLine());
				System.out.println(co.remove(removeid) ? "Removed successfully" : "not removed");
				break;
			case 5:
				System.out.println("Enter the id to be updated:");
				int updateId = Integer.parseInt(scan.nextLine()); // input for id number
				System.out.println("Enter the course details");
				String updateData = scan.nextLine(); // input for updated data
				CourseClass updatedCourseClass = CourseClass.createCourseClass(updateData);
				boolean result = co.updateCourseClass(updateId, updatedCourseClass);
				System.out.println(result ? "updated" : "not get updated");
				break;
			case 6:
				System.out.println("High  course in the list");
				List<CourseClass> top = pcourse.findGoodCourse(courseList);
				System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
						"skillLevel", "duration", "rating");
				for (CourseClass course : top) {
					System.out.println(course);
				}

				break;
			case 7:
				System.out.println("The low course list is");
				List<CourseClass> low = pcourse.findpoorCourse(courseList);
				System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
						"skillLevel", "duration", "rating");
				for (CourseClass course : low) {
					System.out.println(course);
				}
				break;
			case 8:
				System.out.println("Type your area of interest in programming language :");
				String inputdata = scan.nextLine();
				List<CourseClass> area = pcourse.findInterestCourse(courseList, inputdata);
				System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
						"skillLevel", "duration", "rating");
				for (CourseClass course : area) {
					System.out.println(course);
				}

				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue (y/n)");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y');

	}

}
