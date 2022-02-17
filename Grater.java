import java.util.*;
public class Grater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter num1:");
      int num1=scan.nextInt();
      System.out.println("Enter num2:");
      int num2=scan.nextInt();
      System.out.println("Enter num3:");
      int num3=scan.nextInt();
      System.out.println("Enter num4:");
      int num4=scan.nextInt();
      
      if ((num1==num2)&&(num2==num3)&&(num3==num4)&&(num4==num1))
      {
    	  System.out.println("All are equal");
      }
          
      else if((num1>num2) &&  (num1>num3) && (num1>num4) ) 
      {
         System.out.println("num 1 is Greater");
         
      }
      else if((num2>num3)&&(num2>num4)) 
      {
         System.out.println("num 2 is Greater");
         
      }
      else if((num3>num4)) 
      {
         System.out.println("num 3 is Greater");
         
      }
      else 
      {
         System.out.println("num 4 is Greater");
         
      }
      }

}
