package hibernate.mvc.service;

import java.util.List;

import hibernate.mvc.entity.Student;

public interface StudentService {
	Student findById(int id);

	void saveStudent(Student student);

	void updateStudent(Student student);

	void deleteById(int id);

	List<Student> findAllStudents();

	List<Student> findAllStudents(String search);

	boolean isStudentIdUnique(Integer id);

	List<Student> getStudents(int fromIndex, int toIndex);

	List<Student> getStudents(int fromIndex, int toIndex, String search);

}