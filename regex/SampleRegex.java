package com.technocis.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SampleRegex {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your first name(start with caps):");
		String fname=scan.nextLine();
		System.out.println("Enter your last name:");
		String lname=scan.nextLine();
		System.out.println("Enter your phone number:");
		String pnumber=scan.nextLine();
		System.out.println("Enter your mail:");
		String mail=scan.nextLine();
		System.out.println(Pattern.matches("[A-Z]{1}[a-z]{3,}", fname)?"valid":"invalid" );

System.out.println(Pattern.matches("[A-Za-z]{3,}", lname)?"valid":"invalid" );

System.out.println(Pattern.matches("[6789][0-9]{9}", pnumber)?"valid":"invalid" );

System.out.println(Pattern.matches("[a-z]+[0-9][@][a-z][.][a-z]", mail)?"valid":"invalid" );

	}

}
