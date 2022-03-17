package jdbcstudentmodel;

import java.util.Date;

public class Student {
	private Integer studentid;
	private String studentName;
	private String status;
	private Date date;
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Student(Integer studentid, String studentName, String status, Date date) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
		this.status = status;
		this.date = date;
		
	}
	
	public Student(String studentName, String status, Date date) {
		super();
		this.studentName = studentName;
		this.status = status;
		this.date = date;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Attendance [studentid=" + studentid + ", studentName=" + studentName + ", status=" + status + ", date="
				+ date + "]";
	}
	

}
