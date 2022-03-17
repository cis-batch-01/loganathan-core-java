package jdbcstudentdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import jdbcstudentmodel.Student;

public class StudentDAOImpl implements StudentDAO {
	static String insertstudent="insert into student (student_name,status,date)values(?,?,?)"; 
	static String updatestudent=" update  student set student_name=?,status=?,date=? where student_id=?";
	static  String selectstudent="select student_name,status,date from student where student_id=?";
	
	public Student addStudent(Student student) {
		
	Connection con =ConnectionUtil.getDBconnect();
		
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement(insertstudent);
		 pstmt.setString(1,student.getStudentName());
		   pstmt.setString(2,student.getStatus());
      pstmt.setDate(3,new java.sql.Date(student.getDate().getTime()));	//
		   int rs=pstmt.executeUpdate();
		   if(rs>0) {
			   return student;
		   }
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		  
		   
	return null;
	}
	public Student updateStudent(int id, Student student) {
		Connection con =ConnectionUtil.getDBconnect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(updatestudent);
			pstmt.setString(1,student.getStudentName());
			   pstmt.setString(2,student.getStatus());
	        pstmt.setDate(3,new java.sql.Date(student.getDate().getTime()));	
			   pstmt.setInt(4,id);
			   int rs=pstmt.executeUpdate();
			   if(rs>0) {
				 return student;  
			   }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		return null;
	}
	public Student selectStudent(int id) {
		Connection con =ConnectionUtil.getDBconnect();
		 PreparedStatement pstmt;
		 Student student=null;
		try {
			pstmt = con.prepareStatement(selectstudent);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			   
			   if(rs.next()) {
				   student=new Student(id,rs.getString(1),rs.getString(2),rs.getDate(3));
				   
			   }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		   
		
		return student;
	}
}
