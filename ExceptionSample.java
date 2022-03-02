package com.IteratableSample;

public class ExceptionSample {

	public static void main(String[] args) {
		int num=0;
		int multi=0;
		int res=num*multi;
		try {
			System.out.println("number  exception");
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		finally 
		{
			System.out.println("zero multiplication");
		}

	}

}
