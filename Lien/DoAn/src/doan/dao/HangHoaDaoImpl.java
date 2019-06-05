package doan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import doan.entity.HangHoa;

@Repository
public class HangHoaDaoImpl extends AbstractDao<Integer, HangHoa> implements HangHoaDao {
	public HangHoa findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveHangHoa(HangHoa HangHoa) {
		persist(HangHoa);
	}

	@Override
	public void deleteHangHoaById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HangHoa> findAllHangHoa() {
		Criteria criteria = createEntityCriteria();
		return (List<HangHoa>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HangHoa> findAllHangHoa(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenHang", "%" + search + "%");
		criteria.add(cond);
		return (List<HangHoa>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HangHoa> getHangHoa(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<HangHoa>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<HangHoa> getHangHoa(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("tenHang", "%" + search + "%");
		criteria.add(cond);
		return (List<HangHoa>) criteria.list().subList(fromIndex, toIndex);
	}

}