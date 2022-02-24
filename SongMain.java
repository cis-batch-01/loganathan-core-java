package com.technocis.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SongMain {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		// Auto-generated method stub
		SimpleDateFormat sd=new SimpleDateFormat("mm:ss");
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the 1 st song :");
		String song1=scan.nextLine();
		System.out.println("Enter the 2nd song :");
		String song2=scan.nextLine();	
		String[] data1 = song1.split(",");
        Song s1=new Song(data1[0],data1[1],sd.parse(data1[2]),Double.parseDouble(data1[3]));
		System.out.println("song 1 :");
		System.out.println(s1);
		String[] data2 = song2.split(",");
		Song s2=new Song(data2[0],data2[1],sd.parse(data2[2]),Double.parseDouble(data2[3]));
		System.out.println("song 2 :");
		System.out.println(s2);
		
	
		System.out.println(song1.equals(song2)?"Song 1 and 2 are same" :"Song is diffrent");
		
	}


}
