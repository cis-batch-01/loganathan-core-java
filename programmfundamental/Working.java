package com.technocis;

import java.util.Arrays;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Working {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no.of doctor");
		int num = Integer.parseInt(scan.nextLine());
		int totalDoctorId[] = new int[num];
		System.out.println("Enter  the AllDoctorId number one by one :");
		for (int index = 0; index  < totalDoctorId.length; index ++) {
			totalDoctorId[index] = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Enter the no.of working  doctor id ");
		int number = Integer.parseInt(scan.nextLine());
		int working[] = new int[number];
		System.out.println("Enter  the working  doctor id number one by one :");
		for (int index = 0; index< working.length;index++) {
			working[index] = Integer.parseInt(scan.nextLine());
		} 		  
		int flag=0;
		int nonworkingDoctor[]=new int[totalDoctorId.length];
		for(int outer=0;outer<totalDoctorId.length;outer++)
		{
			for(int inner=0;inner<working.length;inner++)
			{
				if(totalDoctorId[outer]==working[inner])
				{
					flag=0;
					break;
				}
				else {
					flag=1;
				}			
			}
		
			if(flag==1) {
				nonworkingDoctor[outer]=totalDoctorId[outer];
				
			}
		}System.out.println("nonWorking Doctors id  is :"+Arrays.toString(nonworkingDoctor));
		
		}

	}
