package hibernate.students.dao;

import java.util.List;

import hibernate.students.entity.Student;

public interface StudentDao {
	Student findById(int id);

	void saveStudent(Student student);

	void deleteStudentById(int id);

	List<Student> findAllStudents();

	List<Student> findAllStudents(String search);

	List<Student> getStudents(int fromIndex, int toIndex);

	List<Student> getStudents(int fromIndex, int toIndex, String search);

}
