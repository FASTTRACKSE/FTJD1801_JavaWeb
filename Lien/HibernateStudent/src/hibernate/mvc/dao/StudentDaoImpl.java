package hibernate.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import hibernate.mvc.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {
	public Student findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveStudent(Student student) {
		persist(student);
	}

	@Override
	public void deleteStudentById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudents() {
		Criteria criteria = createEntityCriteria();
		return (List<Student>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudents(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenSV", "%" + search + "%");
		criteria.add(cond);
		return (List<Student>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<Student>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudents(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenSV", "%" + search + "%");
		criteria.add(cond);
		return (List<Student>) criteria.list().subList(fromIndex, toIndex);
	}
}
