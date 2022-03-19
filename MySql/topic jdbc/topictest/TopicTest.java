package com.topictest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.topicdao.TopicDAO;
import com.topicdao.TopicDAOImpl;
import com.topicmodel.Topic;

public class TopicTest {

	static public void topicManager() {
		Scanner scan = new Scanner(System.in);
		System.out.println("The Topic details is ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		TopicDAO ts = new TopicDAOImpl();
		char choice = 'n';
		do {

			System.out.println("1.get topic \n2.get all topic \n3.add topic\n4.update topic\n5.delete topic");
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1:
				System.out.println("enter the topic id");
				int selectid = Integer.parseInt(scan.nextLine());
				;
				Topic topic = ts.getTopic(selectid);
				System.out.println(topic != null ? "id data is showed" + topic : "no data found");
				break;
			case 2:
				List<Topic> topicList = ts.getAllTopic();
				for (Topic top : topicList) {
					System.out.println(top != null ? "The all topic details are \n " + top : "data is not found");
				}
				break;
			case 3:
				System.out.println("enter the topic details");
				System.out.println("To enter this details(Topicname,description,content,date)");
				String insertdata = scan.nextLine();
				String data[] = insertdata.split(",");
				Topic inserttopic;
				try {
					inserttopic = new Topic(data[0], data[1], data[2], sdf.parse(data[3]));
					Topic insert = ts.addTopic(inserttopic);
					System.out.println(insertdata != null ? "data inserted \n" + insertdata : "data not inserted");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("enter the id");
				int updateid = Integer.parseInt(scan.nextLine());
				Topic oldData = ts.getTopic(updateid);
				if (oldData == null) {
					System.out.println("no Record found");
				} else {
					System.out.println(oldData + "\n updatetopic");
					System.out.println("To enter this details(Topicname,description,content,date)");
					String updatedata = scan.nextLine();
					String edit[] = updatedata.split(",");
					Topic updatetopic;
					try {
						updatetopic = new Topic(edit[0], edit[1], edit[2], sdf.parse(edit[3]));
						Topic restopic = ts.updateTopic(updateid, updatetopic);
						System.out.println(restopic != null ? "data is  updated" + restopic : "data  is not updated");
					} catch (NumberFormatException e) {

						e.printStackTrace();
					} catch (ParseException e) {

						e.printStackTrace();
					}

				}

				break;
			case 5:
				System.out.println("enter the id");
				int deleteid = Integer.parseInt(scan.nextLine());
				Topic delid = ts.deleteTopic(deleteid);
				System.out.println(delid != null ? "data is deleted" + delid : "data is not deleted");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want continue in topic details:");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');
	}
}
