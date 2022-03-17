package jdbcstudentdao;

import jdbcstudentmodel.Student;

public interface StudentDAO {

	public Student addStudent(Student student);
	public Student updateStudent(int id,Student student);
	public Student selectStudent(int id);
}
