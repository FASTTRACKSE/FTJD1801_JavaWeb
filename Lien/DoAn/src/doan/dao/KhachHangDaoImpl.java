package doan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import doan.entity.KhachHang;


@Repository
public class KhachHangDaoImpl extends AbstractDao<Integer, KhachHang> implements KhachHangDao {
	public KhachHang findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveKhachHang(KhachHang KhachHang) {
		persist(KhachHang);
	}

	@Override
	public void deleteKhachHangById(int id) {
		delete(getByKey(id));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public KhachHang login(String userEmail, String userPass) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> findAllKhachHang() {
		Criteria criteria = createEntityCriteria();
		return (List<KhachHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> findAllKhachHang(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenKhachHang", "%" + search + "%");
		criteria.add(cond);
		return (List<KhachHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> getKhachHang(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<KhachHang>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<KhachHang> getKhachHang(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenKhachHang", "%" + search + "%");
		criteria.add(cond);
		return (List<KhachHang>) criteria.list().subList(fromIndex, toIndex);
	}

}