package hibernate.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.mvc.dao.StudentDao;
import hibernate.mvc.entity.Student;


@Transactional
@Service("employeeService")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao dao;
	
	@Override
	public Student findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		Student entity = dao.findById(student.getMaSV());
		if (entity != null) {
			entity.setTenSV(student.getTenSV());
			entity.setNamSinh(student.getNamSinh());
			entity.setAvatar(student.getAvatar());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteStudentById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}
	
	@Override
	public List<Student> findAllStudents(String search) {
		return dao.findAllStudents(search);
	}

	@Override
	public 	List<Student> getStudents(int fromIndex, int toIndex) {
		return dao.getStudents(fromIndex, toIndex);
	}
	@Override
	public 	List<Student> getStudents(int fromIndex, int toIndex,String search) {
		return dao.getStudents(fromIndex, toIndex,search);
	}
	@Override
	public boolean isStudentIdUnique(Integer id) {
        Student student = findById(id);
        return ( student == null || (id != null));
	}

}