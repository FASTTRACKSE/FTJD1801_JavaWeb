package doan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import doan.entity.ChiTietDonHang;

@Repository
public class ChiTietDonHangDaoImpl extends AbstractDao<Integer, ChiTietDonHang> implements ChiTietDonHangDao {
	public ChiTietDonHang findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveChiTietDonHang(ChiTietDonHang ChiTietDonHang) {
		persist(ChiTietDonHang);
	}

	@Override
	public void deleteChiTietDonHangById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChiTietDonHang> findAllChiTietDonHang() {
		Criteria criteria = createEntityCriteria();
		return (List<ChiTietDonHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChiTietDonHang> findAllChiTietDonHang(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("maDonHang", "%" + search + "%");
		criteria.add(cond);
		return (List<ChiTietDonHang>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChiTietDonHang> getChiTietDonHang(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<ChiTietDonHang>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<ChiTietDonHang> getChiTietDonHang(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("maDonHang", "%" + search + "%");
		criteria.add(cond);
		return (List<ChiTietDonHang>) criteria.list().subList(fromIndex, toIndex);
	}

}