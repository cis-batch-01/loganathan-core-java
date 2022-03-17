package jdbcstudent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import jdbcstudentmodel.Student;
import jdbcstudentservice.StudentServiceDAO;
import jdbcstudentservice.StudentServiceDAOImpl;

public class StudentTest {
 
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		  System.out.println("Student Attendance Details ");
		  StudentServiceDAO ssd=new StudentServiceDAOImpl();
		  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		  char choice='n';
		  do{
		  System.out.println("1.insert student \n 2.update student\n3.select student");
		  int num=Integer.parseInt(scan.nextLine());
		  switch(num){
		           case 1:
				   System.out.println("please enter the student Detail");
				   System.out.println("This  details  to be enter (studentname,studentstatus,date) ");
				   String data=scan.nextLine();
				   String datas[]=data.split(",");
			Student newstudent;
			try {
				newstudent = new Student(datas[0],datas[1],sdf.parse(datas[2]));
				ssd.addStudent(newstudent);
				System.out.println(newstudent!=null ?"data is inserted"+newstudent:"data is not inserted");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				    
				   break;
		          case 2:
				  
				   System.out.println("please enter the id to update");
				   int updateid=Integer.parseInt(scan.nextLine());
				   System.out.println("This  details  to be enter (studentname,studentstatus,date) ");
				   String updatedData=scan.nextLine();
				   String dataupdate[]=updatedData.split(",");
					Student editstudent;
					try {
						editstudent = new Student(dataupdate[0],dataupdate[1],sdf.parse(dataupdate[2]));
						 Student student =ssd.updateStudent(updateid, editstudent);
						System.out.println(editstudent!=null ?"data is inserted"+editstudent:"data is not inserted");
					} catch (ParseException e) {
					
						e.printStackTrace();
					}
				   
				  
				   break;
				   case 3:
				   System.out.println("please enter the id ");
				   int selectid=Integer.parseInt(scan.nextLine());
				   Student student=ssd.selectStudent(selectid);
				   System.out.println(student!= null ?"given id correct  "+student:"no data found");
				   break;
				   default:
				   System.out.println(" Invalid choice \n please select another choice");
				   break;
		  }
		  
		  System.out.println(" Do you want continue :");
		    choice=scan.nextLine().charAt(0);
		  }while(choice=='y');

}
}
