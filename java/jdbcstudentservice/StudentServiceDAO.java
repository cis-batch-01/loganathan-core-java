package jdbcstudentservice;

import jdbcstudentmodel.Student;

public interface StudentServiceDAO {
	public Student addStudent(Student student);
	public Student updateStudent(int id,Student student);
	public Student selectStudent(int id);
}
