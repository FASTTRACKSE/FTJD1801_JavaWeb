package doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.dao.HangHoaDao;
import doan.entity.HangHoa;

@Transactional
@Service
public class HangHoaServiceImpl implements HangHoaService {
	@Autowired
	private HangHoaDao hangHoaDao;

	@Override
	public HangHoa findById(int id) {
		return hangHoaDao.findById(id);
	}

	@Override
	public void saveHangHoa(HangHoa HangHoa) {
		hangHoaDao.saveHangHoa(HangHoa);
	}

	@Override
	public void updateHangHoa(HangHoa HangHoa) {
		HangHoa entity = hangHoaDao.findById(HangHoa.getMaHang());
		if (entity != null) {
			entity.setTenHang(HangHoa.getTenHang());;
			entity.setNhomHang(HangHoa.getNhomHang());;
			entity.setDonGia(HangHoa.getDonGia());;
			entity.setDonViTinh(HangHoa.getDonViTinh());;
			entity.setSoLuong(HangHoa.getSoLuong());;
			entity.setThongTin(HangHoa.getThongTin());;
			entity.setNguonGoc(HangHoa.getNguonGoc());;
			entity.setFile(HangHoa.getFile());;
		}
	}

	@Override
	public void deleteById(int id) {
		hangHoaDao.deleteHangHoaById(id);
	}

	@Override
	public List<HangHoa> findAllHangHoa() {
		return hangHoaDao.findAllHangHoa();
	}

	@Override
	public List<HangHoa> findAllHangHoa(String search) {
		return hangHoaDao.findAllHangHoa(search);
	}

	@Override
	public List<HangHoa> getHangHoa(int currentPage, int perPage) {
		return hangHoaDao.getHangHoa(currentPage, perPage);
	}

	@Override
	public List<HangHoa> getHangHoa(int currentPage, int perPage, String search) {
		return hangHoaDao.getHangHoa(currentPage, perPage, search);
	}

	@Override
	public boolean isHangHoaIdUnique(Integer id) {
		HangHoa HangHoa = findById(id);
		return (HangHoa == null || (id != null));
	}
}