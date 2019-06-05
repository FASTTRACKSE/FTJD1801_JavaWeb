package doan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import doan.entity.DonHang;

@Repository
public class DonHangDaoImpl extends AbstractDao<Integer, DonHang> implements DonHangDao {
	public DonHang findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveDonHang(DonHang DonHang) {
		persist(DonHang);
	}

	@Override
	public void deleteDonHangById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonHang> findAllDonHang() {
		Criteria criteria = createEntityCriteria();
		return (List<DonHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonHang> findAllDonHang(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("trangThai", "%" + search + "%" );
		criteria.add(cond);
		return (List<DonHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonHang> getDonHang(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<DonHang>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<DonHang> getDonHang(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("trangThai", "%" + search + "%");
		criteria.add(cond);
		return (List<DonHang>) criteria.list().subList(fromIndex, toIndex);
	}

}