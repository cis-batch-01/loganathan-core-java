package com.workout;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;



public class MainClass {
public static void main(String[] args) throws ParseException {
	Scanner scan = new Scanner(System.in);
	Repository top = new RepositoryImpl();
	System.out.println("Course Manipulation api");
	char choice = 'n';
	do {
		System.out.println("1.Get all topics\n2.get a topics\n3.Add a topics\n4.remove topics\n5.update topics");
		int option = Integer.parseInt(scan.nextLine());
		switch (option) {
		case 1:
			List<Topic> topicList = top.getAllTopic();
			System.out.println("Elemets from the Storage");
			if (!topicList.isEmpty()) {
				for (Topic topic : topicList) 
				{
					System.out.println(topic); 
				}
			}
			else
			{
				System.out.println("the  list is empty");
			}
			break;
		case 2:
			System.out.println("Enter the topic id:");
			int id = Integer.parseInt(scan.nextLine());
	           Topic topic = top.get(id);
			System.out.println(topic!=null?topic:"id not found");
			break;
		case 3:
			System.out.println("Enter the course Details");
			String data = scan.nextLine();
			Topic topicNew = Topic.createTopic(data);
			boolean res=top.add(topicNew);
			System.out.println(res?"Cast Added successfully":"storage is full");//ternary operation
			break;
		case 4:
			System.out.println("Enter the id to be removed");
			int id1=Integer.parseInt(scan.nextLine());
			System.out.println(top.remove(id1)?"Removed successfully":"not removed");
			break;
		case 5:
			System.out.println("Enter the id to be updated:");
			int updateId=Integer.parseInt(scan.nextLine()); //input for id number
			System.out.println("Enter the details");
			String updateData=scan.nextLine();                //input for updated data
		Topic updatedTopic=Topic.createTopic(updateData);
		
		boolean result=top.update(updateId, updatedTopic);
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
