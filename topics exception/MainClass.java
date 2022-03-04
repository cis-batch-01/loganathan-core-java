package com.topics;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;




public class MainClass {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		Repository chap = new RepositoryImpl();
		System.out.println("Chapter Manipulation api");
		char choice = 'n';   
		do {
			System.out.println("1.Get all  Chapter\n2.get a  Chapter\n3.Add a  Chapter\n4.remove  Chapter\n5.update  Chapter");
			System.out.println("Select your choice");
			int option = Integer.parseInt(scan.nextLine());
			
			switch (option) {
			case 1:
				List< Chapter> chapterList = chap.getAllChapter();
				System.out.println("Elemets from the Storage");
				if (!chapterList.isEmpty()) {
					System.out.format("%-15s%-16s%-16s%-15s%-15s%-15s\n", "ChapterId", "topicName", "description", "content",
							"language","createDate");
					for ( Chapter  chapter : chapterList) 
					{
						System.out.println( chapter); 
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
				
				Chapter chapter= chap.get(id);
		          
				try {
					if(chapter==null) {
						throw new ChapterNotFoundException("check id");
					}
					else {
						System.out.println(chapter);
					}
				}
				catch(Exception e){
					
					System.out.println(e);
					
				}
				 System.out.format("%-15s%-16s%-16s%-15s%-15s%-15s\n", "topicId", "topicName", "description", "content",
							"language","createDate");
				System.out.println(chapter!=null?chapter:"id not found");
				break;
			case 3:
				System.out.println("Enter the topic Details");
				String data = scan.nextLine();
			Chapter chapterNew = Chapter.createChapter(data);
			    boolean res=chap.add(chapterNew);
				System.out.println(res?"Topic Added successfully":"storage is full");//ternary operation
				break;
			case 4:
				System.out.println("Enter the id to be removed");
				int id1=Integer.parseInt(scan.nextLine());
				System.out.println(chap.remove(id1)?"Removed successfully":"not removed");
				break;
			case 5:
				System.out.println("Enter the id to be updated:");
				int updateId=Integer.parseInt(scan.nextLine()); //input for id number
				System.out.println("Enter the topic details");
				String updateData=scan.nextLine();                //input for updated data
				
			Chapter updatedChapter=Chapter.createChapter(updateData);
				boolean result=chap.update(updateId, updatedChapter);
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
