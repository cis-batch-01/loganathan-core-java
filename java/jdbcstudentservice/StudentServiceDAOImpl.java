package jdbcstudentservice;

import jdbcstudentdao.StudentDAO;
import jdbcstudentdao.StudentDAOImpl;
import jdbcstudentmodel.Student;

public class StudentServiceDAOImpl implements StudentServiceDAO {

	StudentDAO studentdao=new StudentDAOImpl();
	public Student addStudent(Student student) {
		
		return studentdao.addStudent(student);
	}

	public Student updateStudent(int id, Student student) {
	
		return studentdao.updateStudent(id, student);
	}

	public Student selectStudent(int id) {
		
		return studentdao.selectStudent(id);
	}
	

}
