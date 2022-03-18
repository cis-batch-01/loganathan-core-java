package com.topictest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.topicdao.TopicDAO;
import com.topicdao.TopicDAOImpl;
import com.topicmodel.Topic;

public class TopicTest {
	public static void main(String args[]){
		   Scanner scan=new Scanner(System.in);
		   System.out.println("The course details is ");
		   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		   TopicDAO ts=new  TopicDAOImpl();
		   System.out.println("1.topic details\n2.question ");
		   char choice='n';
		   do{
		  
		    System.out.println("1.get topic \n2.get all topic \n3.add topic\n4.update topic\n5.delete topic");
		   int option=Integer.parseInt(scan.nextLine());
		   switch(choice){
		   case 1 :
		    System.out.println("enter the topic id");
			int selectid=Integer.parseInt(scan.nextLine());;
			Topic topic=ts.getTopic(1);
			System.out.println(topic);
			break;
			case 2 :
			List<Topic> topicList=null;
		    topicList=ts.getAllTopic();
			for(Topic top: topicList){
			System.out.println(top);
			}
			break;
			case 3 :
			
		    System.out.println("enter the topic details");
			System.out.println("To enter this details(Topicname,description,content,date)");
			String insertdata=scan.nextLine();
			String data []=insertdata.split(",");
			Topic inserttopic;
			try {
				inserttopic = new Topic(Integer.parseInt(data[0]),data[1],data[2],data[3],sdf.parse(data[4]));
				Topic insert=ts.addTopic(inserttopic);
				System.out.println(insertdata!=null?"data inserted"+insertdata:"data not inserted");	
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			case 4:
		    System.out.println("enter the id");
			int updateid=Integer.parseInt(scan.nextLine());
			System.out.println("To enter this details(Topicname,description,content,date)");
			String updatedata=scan.nextLine();
			String edit []=updatedata.split(",");
			Topic update;
			try {
				update = new Topic(Integer.parseInt(edit[0]),edit[1],edit[2],edit[3],sdf.parse(edit[4]));
				Topic newupdate=ts.updateTopic(updateid, update);
				System.out.println(updatedata!=null?"data is  updated"+updatedata:"data  is not updated");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			break;
			case 5 :
		    System.out.println("enter the id");
			int deleteid=Integer.parseInt(scan.nextLine());
			Topic delid=ts.deleteTopic(deleteid);
			System.out.println(delid);
			break;
			default:
			System.out.println("Invalid choice");
			break;
		   }
		   
		   System.out.println("do you want continue:");
			  choice=scan.nextLine().charAt(0);
		   }while(choice=='y'||choice=='Y');
	}
}

