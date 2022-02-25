package collectionSample;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CollectionSample {

	public static void main(String[] args) {
		//  Auto-generated method stub
		Set<String> set=new TreeSet<String>();
		Scanner scan=new Scanner(System.in);
//		System.out.println("Enter student name :");
//		String data=scan.nextLine();
//		
//		set.add(data);
//		System.out.println(set);
		
		char choice='n';
		do {
			System.out.println("Enter student name :");
		String data=scan.nextLine();
	 set.add(data);
	  System.out.println("Do you continue(y/n) :");
			choice=scan.nextLine().charAt(0); 
			
		}while(choice=='y');
		
		System.out.println(set);
		
	}

}
