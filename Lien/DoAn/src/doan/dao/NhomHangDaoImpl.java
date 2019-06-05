package doan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import doan.entity.NhomHang;

@Repository
public class NhomHangDaoImpl extends AbstractDao<Integer, NhomHang> implements NhomHangDao {
	public NhomHang findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveNhomHang(NhomHang NhomHang) {
		persist(NhomHang);
	}

	@Override
	public void deleteNhomHangById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhomHang> findAllNhomHang() {
		Criteria criteria = createEntityCriteria();
		return (List<NhomHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhomHang> findAllNhomHang(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenNhom", "%" + search + "%");
		criteria.add(cond);
		return (List<NhomHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhomHang> getNhomHang(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<NhomHang>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<NhomHang> getNhomHang(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenNhom", "%" + search + "%");
		criteria.add(cond);
		return (List<NhomHang>) criteria.list().subList(fromIndex, toIndex);
	}

}