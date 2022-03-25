package com.technocis.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.validation.Validator;

public class UserRegex {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		System.out.println("Enter your first name(start with caps):");
		String  fname = scan.nextLine();
		boolean name = UserRegex.firstNameValidate(fname);
		System.out.println(name?"data is vaild":"data is not valid");
	
		System.out.println("Enter your last name:");
		String lname = scan.nextLine();
		boolean userlname = UserRegex.lastNameValidate(lname);
		System.out.println(userlname?"data is vaild":"data is not valid");
		System.out.println("Enter your userphone");
		String phone = scan.nextLine();
		Long.parseLong(phone);
		boolean userphone = UserRegex.phoneValidate(phone);
		System.out.println(userphone?"data is vaild":"data is not valid");
		System.out.println("Enter your mail");
		String mail = scan.nextLine();
		boolean usermail = UserRegex.mailValidate(mail);
		System.out.println(usermail?"data is vaild":"data is not valid");
		System.out.println("Enter your password ");
		String password  = scan.nextLine();
		boolean userpassword  = UserRegex.passwordValidate(password );
		System.out.println(userpassword ?"data is vaild":"data is not valid");
	}

	public static boolean firstNameValidate(String firstName) {

//	   Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]{3,}",);
//       Matcher matcher = pattern.matcher(firstName);
		boolean name = Pattern.matches("[A-Z]{1}[a-z]{3,}", firstName);

		return name;
	}

	public static boolean lastNameValidate(String lastName) {

		boolean userlname = Pattern.matches("[A-Za-z]{3,}", lastName);
		return userlname;
	}
	public static boolean phoneValidate(String  phone) {

		boolean userphone = Pattern.matches("[6789]{1}[0-9]{9}",  phone);

		return userphone;
	}
	public static boolean mailValidate(String mail) {

		boolean usermail = Pattern.matches("[a-z0-9_-]+[@][a-z]+[.][a-z]{2,3}",  mail);
		
		return usermail;
	}
	public static boolean passwordValidate(String  password) {

		boolean userpassword = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", password );

		return userpassword;
	}
}
