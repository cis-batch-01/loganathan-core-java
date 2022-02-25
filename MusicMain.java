package com.technocis.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MusicMain {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		// Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
		Scanner scan=new Scanner(System.in);
//		System.out.println("Enter song 1 detail:");
//		String song1=scan.nextLine();
//		String[] data1 = song1.split(",");
//        MusicClass s1=new MusicClass(data1[0],data1[1],sdf.parse(data1[2]),Double.parseDouble(data1[3]));
//		
//		
//		System.out.println("Enter song 2 detail:");
//		String song2=scan.nextLine();
//		String[] data2 = song2.split(",");
//		 MusicClass s2=new  MusicClass(data2[0],data2[1],sdf.parse(data2[2]),Double.parseDouble(data2[3]));
//		System.out.println("Songs List");
//		System.out.format("%-15s%-20s%-10s%-6s\n", "Title","Genre","Duration","Rating");
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println();
//	
//		System.out.println(s1.equals(s2)?"Song 1 and 2 are same" :"Songs is diffrent");
		List<MusicClass> musicList=new  ArrayList<MusicClass>();
		char choice='n';
		do
		{
		System.out.println("Add Songs");
		System.out.println("Enter Songs details:");
		String data=scan.nextLine();
		String[] data1=data.split(",");
		MusicClass music=new MusicClass(data1[0],data1[1],sdf.parse(data1[2]),Double.parseDouble(data1[3]));
		//MusicClass.add(MusicClass);
		musicList.add(music);
		System.out.println("Do you want to continue(y/n)");
		choice=scan.nextLine().charAt(0);
		
	}while(choice=='y');
		
		System.out.format("%-15s%-20s%-10s%-6s\n", "Title","Genre","Duration","Rating");
		//System.out.println(musicList);
		Collections.sort(musicList,new RatingCompartor());
		for( MusicClass music:musicList)
		{
			System.out.println(music);
		}

	}
	

}
