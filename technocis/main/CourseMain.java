package com.technocis.main;


import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.technocis.exception.AreaNotFoundException;
import com.technocis.exception.CourseNotFoundException;
import com.technocis.impl.RepositoryImpl;
import com.technocis.lms.CourseModel;
import com.technocis.rating.GetCourse;
import com.technocis.repo.Repository;

public class CourseMain {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		Scanner scan = new Scanner(System.in);
		Repository co = new RepositoryImpl();
		System.out.println("\t  course Details");
		List<CourseModel> courseList = null;
		GetCourse pcourse = new GetCourse();
		char choice = 'n';
		do {
			System.out.println(
					"1.List of  all Course \n2.Fetch  course detail from id \n3.Add  a course\n4.Delete course\n5.Edit a course\n6.High rating courses"
							+ "               \n7.Low rating courses\n8.Area of interest");
			System.out.println(" please Select your choice");
			int option = Integer.parseInt(scan.nextLine());

			switch (option) {
			case 1:
				courseList = co.getAllCourseClass();
				System.out.println("Elemets from the Storage");
				if (!courseList.isEmpty()) {
					System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
							"skillLevel", "duration", "rating");
					for (CourseModel course : courseList) {
						System.out.println(course);
					}
				} else {
					System.out.println("The  list is empty");
				}
				break;
			case 2:
				System.out.println("Enter the course id:");
				int courseid = Integer.parseInt(scan.nextLine());
				CourseModel topic = co.get(courseid);
				try {
					if (topic == null) {
						throw new CourseNotFoundException("please check  your id");
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
				System.out.println("Enter the course Details");
				String data = scan.nextLine();
				CourseModel courseNew = CourseModel.createCourseClass(data);
				boolean res = co.addCourseClass(courseNew);
				System.out.println(res ? "Course Added successfully" : "storage is full");// ternary operation
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
				System.out.println(
						"This details are enter the user ( courseId, courseName, courseContent,skillLevel,duration,rating)");
				String updateData = scan.nextLine(); // input for updated data
				CourseModel updatedCourseClass = CourseModel.createCourseClass(updateData);
				boolean result = co.updateCourseClass(updateId, updatedCourseClass);

				System.out.println(result ? "updated success" : "not get updated");
				break;
			case 6:
				System.out.println("High  course in the list");
				List<CourseModel> top = pcourse.findGoodCourse(courseList);
				if (!top.isEmpty()) {
					System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
							"skillLevel", "duration", "rating");
					for (CourseModel course : top) {
						System.out.println(course);
					}
				} else {
					System.out.println("\t No good cousre");
				}
				break;
			case 7:
				System.out.println("The low course list ");
				List<CourseModel> low = pcourse.findpoorCourse(courseList);
				if (!low.isEmpty()) {
					System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
							"skillLevel", "duration", "rating");
					for (CourseModel course : low) {
						System.out.println(course);
					}
				} else {
					System.out.println("\t No poor cousre");
				}
				break;
			case 8:
				System.out.println("Type your area of interest in programming language :");
				String inputdata = scan.nextLine();
				List<CourseModel> area = pcourse.findInterestCourse(courseList, inputdata);// list object assign
																							// getcourse class object in
																							// used to find
																							// interestcourse
				try {
					if (area.isEmpty()) {
						throw new AreaNotFoundException(
								"This course is not available \n  please Choose another course ");
					} else {
						System.out.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", "courseId", "courseName", "courseContent",
								"skillLevel", "duration", "rating");
						for (CourseModel course : area) {
							System.out.println(course);
						}
					}
				} catch (Exception e) {
					System.out.println(e);

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
