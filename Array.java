package com.technocis.sample;
import java.util.*;
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter no.of Element :");
		int numof=Integer.parseInt(scan.nextLine());
		 int intArray[]= new int[numof];    //use to mutilple value store
//		 int i;
		 intArray[0]=10;
		 System.out.println("Enter numbers");
		for(int i=0;i<numof;i++)
		{
			intArray[i]=Integer.parseInt(scan.nextLine());
		}
		  int result=0;
		  
		  for(int i=0;i<intArray.length;i++)
		  {
			  result+=intArray[i];
			  
		  }
		int avg=result/intArray.length;
		System.out.println("Average of Element"+avg);
		
	}

}
