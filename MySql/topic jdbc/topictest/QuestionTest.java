package com.topictest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.topicdao.QuestionDAO;
import com.topicdao.QuestionDAOImpl;
import com.topicmodel.Question;
import com.topicmodel.Topic;

public class QuestionTest {
	static public void questionManager() {
		Scanner scan = new Scanner(System.in);
		System.out.println("The Question details is ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		QuestionDAO questionDao = new QuestionDAOImpl();
		char choice = 'n';
		do {

			System.out.println(
					"1.get Question\n2.get all Question \n3.add Question\n4.update Question\n5.delete Question");
			int option = Integer.parseInt(scan.nextLine());
			switch (option) {
			case 1:
				try {
					System.out.println("enter the Question id");
					int selectid = Integer.parseInt(scan.nextLine());
					Question question = questionDao.getQuestion(selectid);
					System.out.println(question != null ? "id data is showed" + question : "no data found");
				} catch (NumberFormatException e1) {
					
					System.out.println(" id is integer value"+e1);
				}
				break;
			case 2:
				List<Question> resList = questionDao.getAllQuestion();
				if (resList.isEmpty()) {
					System.out.println("no record to show");

				} else {
					for (Question quest : resList) {

						System.out.println(quest);
					}
				}
				break;
			case 3:
				System.out.println("enter the question details");
				System.out.println("To enter this details(Questioncontent,topicname)");
				String insertdata = scan.nextLine();
				String data[] = insertdata.split(",");
				Question insertQuestion;
				try {
					insertQuestion = new Question(data[0], data[1]);
					Question insert = questionDao.addQuestion(insertQuestion);
					System.out.println(insertdata != null ? "data inserted" + insertdata : "data not inserted");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("enter the id");
				int updateid = Integer.parseInt(scan.nextLine());
				System.out.println("enter the question details");
				System.out.println("To enter this details(Questioncontent,topicname)");
				String updateData = scan.nextLine();
				String edit[] = updateData.split(",");

				Question updateQuest;
				try {
					updateQuest = new Question(edit[0], edit[1]);
					Question updateQuestion = questionDao.updateQuestion(updateid, updateQuest);
					System.out.println(updateData != null ? "data is  updated" + updateData : "data  is not updated");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("enter the id");
				int deleteid = Integer.parseInt(scan.nextLine());
				Question delid = questionDao.deleteQuestion(deleteid);
				System.out.println(delid != null ? "data is deleted" + delid : "data is not deleted");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want continue in question details :");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}
}
