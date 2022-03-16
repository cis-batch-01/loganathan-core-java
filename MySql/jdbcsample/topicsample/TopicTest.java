package com.topicsample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.jdbcsampletopic.Topic;
import com.jdbcsampletopicservice.TopicService;
import com.jdbcsampletopicservice.TopicServiceImpl;

public class TopicTest {
 public static void main(String[] args) throws NumberFormatException, IOException {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		TopicService topicService=new TopicServiceImpl();
		Scanner scan=new Scanner(System.in);
		System.out.println("THE TOPIC DETAILS");
		char choice ='n';
		do {
			System.out.println("1.get a Topic\n2.Get All Topic\n3.Create Topic\n4.update Topic\n5.DeleteTopic");
			int option=Integer.parseInt(br.readLine());
		switch(option)
		{
		case 1:
			System.out.println("Enter the id to show topic details");
			int id=Integer.parseInt(br.readLine());
			Topic topic=topicService.getTopic(id);
			System.out.println(topic);
			break;
		case 2:
			List<Topic>topicList=topicService.getAllTopic();
			for(Topic top:topicList)
			{
				System.out.println(top);
			}
			break;
		case 3:
			
			System.out.println("Enter the Topic details");
			System.out.println("This details to be enter(topic_name,description,content,created_date,updated_date)");
			String detail=br.readLine();
			String datas[]=detail.split(",");
			Topic newTopic;
			try {	
			newTopic = new Topic(  datas[0], datas[1],datas[2],sdf.parse(datas[3]),sdf.parse(datas[4]));
			Topic insertedTopic=topicService.saveTopic(newTopic);
			System.out.println(insertedTopic!=null?"Topic data is inserted \n"+ insertedTopic :"Topic data is not inserted");
			
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			
			break;
		case 4:
			System.out.println("Enter the  id to  updated ");
			int updateId=Integer.parseInt(br.readLine());
			Topic oldTopic =topicService.getTopic(updateId);
			System.out.println(oldTopic);
			System.out.println("Enter the topic  details");
			System.out.println("This details to be enter(topic_id,topic_name,description,content,created_date,updated_date)");
			String updateDetail=br.readLine();
			String updateDatas[]=updateDetail.split(",");
			
			Topic UpdatedTopic =null;
			try {
				UpdatedTopic = new Topic(Integer.parseInt(updateDatas[0]),updateDatas[1],updateDatas[2],updateDatas[3],
						sdf.parse(updateDatas[4]),sdf.parse(updateDatas[5]));
				Topic resTopic=topicService.updateTopic(updateId, UpdatedTopic);
				System.out.println(resTopic!=null?"Topic is updated"+resTopic:"Topic is not updated");
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Enter the id to delete record from table data");
			int deleteid=Integer.parseInt(br.readLine());
			Topic deleteTopic=topicService.deleteTopic(deleteid);
			System.out.println(deleteTopic!=null?"topic is deleted"+deleteTopic:"topic is not deleted ");
			break;
		default:
			System.out.println("Invalid Choice");
		}
		
	System.out.println("Do you want continue(y/n) :");
	choice=scan.nextLine().charAt(0);
	}while(choice=='y');
 
}

}