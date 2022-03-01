package com.Chapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ChapterMain {

	public static void main(String[] args) throws ParseException  {
		//  Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("Enter the no.of chapter");
int num =Integer.parseInt(scan.nextLine());
	List<Chapter> chapterList=new ArrayList<Chapter>();
	System.out.println("Enter your chapters:");
	for(int i=0;i<num;i++) {
		String Data = scan.nextLine();
		Chapter chapter = Chapter.createChapter(Data);
		chapterList.add(chapter);
	}
	System.out.format("%-15s%-16s%-16s%-15s\n", "chapterId","Chapter name","chapterContent","description");
	for (Chapter chapter:chapterList) {

		System.out.println(chapter);
	}
	char choice ='n';
	do {
	System.out.println("1.findById \n2.filter by ChapterName");
	int option = Integer.parseInt(scan.nextLine());
	List<Chapter> resList=null;
	switch (option) {
	case 1:
		System.out.println("enter chapter id :");
		int num1=Integer.parseInt(scan.nextLine());
		
		ChapterBo chapterA=new ChapterBo();//another class object creation
		
		//resList =phoneA.findById(chapterList, num1);
		Chapter chapter=chapterA.findById(chapterList, num1);
		//System.out.println(chapter);
		
		break;
	case 2:
		
		System.out.println("Enter chapter name :");
		String name=scan.nextLine();
		ChapterBo chapB=new ChapterBo();
		
		resList=chapB.filterByChapterName(chapterList, name);
		break;
	default:
		System.out.println("Invalid Choice");
		}
	if(!resList.isEmpty())
	System.out.format("%-15s%-16s%-16s%-15s\n", "chapterId","Chapter name","chapterContent","description");
	for(Chapter chapter:resList) {
		System.out.println(chapter);
	}

	System.out.println("Do you want continue(y/n) :");
	choice=scan.nextLine().charAt(0);
	}while(choice=='y');
	}
	}


