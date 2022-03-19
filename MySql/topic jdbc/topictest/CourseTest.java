package com.topictest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.topicdao.TopicDAO;
import com.topicdao.TopicDAOImpl;
import com.topicmodel.Topic;

public class CourseTest {
	public static void main(String args[]) {

		char firstChoice = 'n';
		do {
			System.out.println("\t Course Details are");
			Scanner scan = new Scanner(System.in);
			System.out.println("1.Topic details\n2.Question ");
			System.out.println("select any one ");
			int userChoice = Integer.parseInt(scan.nextLine());

			switch (userChoice) {
			case 1:
				try {
				TopicTest.topicManager();
				}catch(NumberFormatException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				
				try {
					QuestionTest.questionManager();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invaild choice select other");
				break;
			}
			System.out.println("do you want continue in  Course Details :");
			firstChoice = scan.nextLine().charAt(0);
		} while (firstChoice == 'y' || firstChoice == 'Y');
	}

}