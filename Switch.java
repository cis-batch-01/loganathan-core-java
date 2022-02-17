 import java.util.*;
public class Switch {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Scanner scan =new Scanner(System.in);
 int choice=0;
       System.out.println("Enter your choice");
       choice=scan.nextInt();
       
        switch(choice)
        {
        	case 1:
        	System.out.println("sunday");
        	break;
        	
        	case 2:
            System.out.println("monday");
        	break;
        	
        	case 3:
        		System.out.println("thuesday");
        		break;
        	case 4:
        		System.out.println("wednesday");
        		break;
        	case 5:
        		System.out.println("thursday");
        		break;
        	case 6:
        		System.out.println("friday");
        		break;
        	case 7:
        		System.out.println("saturday");
        		break;
        		default :
        			System.out.println("NO week days");
        }
	}

}
