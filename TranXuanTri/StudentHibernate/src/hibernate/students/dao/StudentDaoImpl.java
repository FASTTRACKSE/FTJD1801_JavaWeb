package hibernate.students.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import hibernate.students.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer,Student> implements StudentDao {
	public Student findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveStudent(Student student) {
		persist(student);
	}

	@Override
	public void deleteStudentById(int id) {
		Query query = getSession().createSQLQuery("delete from student where id ="+id);
        query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudents() {
		Criteria criteria = createEntityCriteria();
		return (List<Student>) criteria.list() ;
	}
}
