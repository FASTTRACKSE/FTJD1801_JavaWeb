package hibernate.students.service;

import java.util.List;

import hibernate.students.entity.Student;

public interface StudentService {
	Student findById(int id);

	void saveStudent(Student student);

	void updateStudent(Student student);

	void deleteById(int id);

	List<Student> findAllStudents();

	boolean isStudentIdUnique(Integer id);

}
