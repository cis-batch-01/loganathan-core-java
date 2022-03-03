package com.interfaceSample;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MainCourse {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		Repository Imp = new RepoClass();
		System.out.println("Course Manipulation api");
		char choice = 'n';
		do {
			System.out.println("1.Get all course\n2.get a course\n3.Add a new Course\n4.remove course\n5.update course");
			int option = Integer.parseInt(scan.nextLine());
			switch (option) {
			case 1:
				List<CourseClass> courseList = Imp.getAllCourseClass();
				System.out.println("Elemets from the Storage");
				if (!courseList.isEmpty()) {
					for (CourseClass course : courseList) {
						System.out.println(course);
					}
				}
				else
				{
					System.out.println("the  list is empty");
				}
				break;
			case 2:
				System.out.println("Enter the Course id:");
				int id = Integer.parseInt(scan.nextLine());
				CourseClass course = Imp.get(id);
				System.out.println(course!=null?course:"id not found");
				break;
			case 3:
				System.out.println("Enter the Course Details");
				String data = scan.nextLine();
				CourseClass courseNew = CourseClass.createCourse(data);
				boolean res=Imp.add(courseNew);
				System.out.println(res?"Course Added successfully":"storage is full");//ternary operation
				break;
			case 4:
				System.out.println("Enter the id to be removed");
				int newId=Integer.parseInt(scan.nextLine());
				System.out.println(Imp.remove(newId)?"Removed successfully":"not removed");
				break;
			case 5:
				System.out.println("Enter the id to be updated:");
				int updateId=Integer.parseInt(scan.nextLine()); //input for id number
				System.out.println("Enter the details");
				String updateData=scan.nextLine();                //input for updated data
				CourseClass updatedCourseClass=CourseClass.createCourse(updateData);
				boolean result=Imp.update(updateId,updateData);
				System.out.println(result?"updated":"not get updated");
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want ot continue (y/n)");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');
	}

}
