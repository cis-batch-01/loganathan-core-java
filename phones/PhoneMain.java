package com.phones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



import topics.Topic;
import topics.TopicBo;

public class PhoneMain {

	public static void main(String[] args) throws ParseException {
		// Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no.of phones :");
		int num = Integer.parseInt(scan.nextLine());
List<Phone> phoneList =new ArrayList<Phone>();
System.out.println("Enter the phone details");
for (int i = 0; i < num; i++) {
	String phoneData = scan.nextLine();
	Phone phone = Phone.createPhone(phoneData);
	phoneList.add(phone);
}
System.out.format("%-15s%-16s%-16s%-15s%-15s\n", "phoneName","company","serious","madeCountry"
		, "manufacturedyearS");
for (Phone phone:phoneList) {

	System.out.println(phone);
}
char choice ='n';
do {
System.out.println("1.filter by companyname\n2.filter by manufacture  date");
int option = Integer.parseInt(scan.nextLine());
List<Phone> resList=null;
switch (option) {
case 1:
	System.out.println("enter company name :");
	String name=scan.nextLine();
	//filterList=Phone.filterByCompanyName(phoneList,name)
	PhoneBo phoneA=new PhoneBo();//another class object creation
	
	resList =phoneA.filterByCompanyName(phoneList, name);
	break;
case 2:
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	System.out.println("Enter modified Year :");
	Date inputdata=sdf.parse(scan.nextLine());
	//filterList=PhoneBo.filterByDate(phoneList, inputdata);
	PhoneBo phoneB=new PhoneBo();
	
	resList=phoneB.filterByDate(phoneList, inputdata);
	break;
default:
	System.out.println("Invalid Choice");
	}
System.out.format("%-15s%-16s%-16s%-15s%-15s\n", "phoneName","company","serious","madeCountry"
		, "manufacturedYear");
for(Phone phone:resList) {
	System.out.println(phone);
}

System.out.println("Do you want continue(y/n) :");
choice=scan.nextLine().charAt(0);
}while(choice=='y');
}
}
