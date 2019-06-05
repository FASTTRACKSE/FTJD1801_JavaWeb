package doan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import doan.entity.NhanVien;

@Repository
public class NhanVienDaoImpl extends AbstractDao<Integer, NhanVien> implements NhanVienDao {
	public NhanVien findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveNhanVien(NhanVien NhanVien) {
		persist(NhanVien);
	}

	@Override
	public void deleteNhanVienById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhanVien> findAllNhanVien() {
		Criteria criteria = createEntityCriteria();
		return (List<NhanVien>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhanVien> findAllNhanVien(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenNhanVien", "%" + search + "%");
		criteria.add(cond);
		return (List<NhanVien>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhanVien> getNhanVien(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<NhanVien>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<NhanVien> getNhanVien(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenNhanVien", "%" + search + "%");
		criteria.add(cond);
		return (List<NhanVien>) criteria.list().subList(fromIndex, toIndex);
	}

}