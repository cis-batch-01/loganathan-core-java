package redmi;
 
import java.util.Scanner;

public class Mark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter tamil mark =");
		int a=sc.nextInt();
		System.out.println("Enter english mark =");
		int b=sc.nextInt();
		System.out.println("Enter maths mark =");
		int c=sc.nextInt();
		System.out.println("Enter science mark =");
		int d=sc.nextInt();
		System.out.println("Enter social science mark =");
		int e=sc.nextInt();
		
		int total=a+b+c+d+e;
		
		System.out.println("Result="+total);
	}

}
