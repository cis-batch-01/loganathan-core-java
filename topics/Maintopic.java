package topics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Maintopic {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		// Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat  sdf=new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Enter the no.of topics");
		int num = Integer.parseInt(scan.nextLine());
		List<Topic> topicList = new ArrayList<Topic>();
		System.out.println("Enter Your topics :");
		for (int i = 0; i < num; i++) {
			String topicData = scan.nextLine();
			Topic topic = Topic.createTopic(topicData);
			topicList.add(topic);
		}
		System.out.format("%-15s%-16s%-16s%-15s%-15s%-15s\n", "topicId", "topicName", "description", "content",
				"createDate", "lastModifiedDate");
		for (Topic topic : topicList) {

			System.out.println(topic);
		}
		char choice ='n';
		do {
		System.out.println("1.filter by topicname\n2.filter by modified  date\n3.sort by topicname \n4.sort by created date");
		int option = Integer.parseInt(scan.nextLine());
		List<Topic> filterList=null;
		switch (option) {
		case 1:
			System.out.println("enter topic name :");
			String name=scan.nextLine();
			filterList=TopicBo.filterByName(topicList,name );
			break;
		case 2:
			System.out.println("Enter modified date :");
			Date inputdata=sdf.parse(scan.nextLine());
			filterList=TopicBo.filterByModifiedDate(topicList, inputdata);
			break;
		case 3:
			filterList=new ArrayList<Topic>(); //empty list
			filterList.addAll(topicList); //duplicate topiclist
			Collections.sort(filterList);//default sort only one argument
			break;
		case 4:
			filterList=new ArrayList<Topic>(); //empty list
			filterList.addAll(topicList); //duplicate topiclist
			Collections.sort(filterList,new DateComparator());//default sort only one argument
			break;
			default:
				System.out.println("Invalid Choice");

		}
		for(Topic topic:filterList) {
			System.out.println(topic);
		}

		System.out.println("Do you want continue(y/n) :");
		choice=scan.nextLine().charAt(0);
		}while(choice=='y');
	}

}
