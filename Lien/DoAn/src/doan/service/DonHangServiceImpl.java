package doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import doan.dao.DonHangDao;
import doan.entity.DonHang;

@Transactional
@Service
public class DonHangServiceImpl implements DonHangService {
	
//	@Qualifier("donHangDao")
	@Autowired
	private DonHangDao donHangDao;

	@Override
	public DonHang findById(int id) {
		return donHangDao.findById(id);
	}

	@Override
	public void saveDonHang(DonHang DonHang) {
		donHangDao.saveDonHang(DonHang);
	}

	@Override
	public void updateDonHang(DonHang DonHang) {
		DonHang entity = donHangDao.findById(DonHang.getMaDonHang());
		if (entity != null) {
			entity.setMaKhachHang(DonHang.getMaKhachHang());
			entity.setNgayDatHang(DonHang.getNgayDatHang());
			entity.setNgayGiaoHang(DonHang.getNgayGiaoHang());
			entity.setDiaChi(DonHang.getDiaChi());
			entity.setTongThanhTien(DonHang.getTongThanhTien());
			entity.setMaNhanVien(DonHang.getMaNhanVien());
			entity.setTrangThai(DonHang.getTrangThai());
			entity.setGiamGia(DonHang.getGiamGia());
			entity.setSoDienThoai(DonHang.getSoDienThoai());
		}
	}

	@Override
	public void deleteById(int id) {
		donHangDao.deleteDonHangById(id);
	}

	@Override
	public List<DonHang> findAllDonHang() {
		return donHangDao.findAllDonHang();
	}

	@Override
	public List<DonHang> findAllDonHang(String search) {
		return donHangDao.findAllDonHang(search);
	}

	@Override
	public List<DonHang> getDonHang(int currentPage, int perPage) {
		return donHangDao.getDonHang(currentPage, perPage);
	}

	@Override
	public List<DonHang> getDonHang(int currentPage, int perPage, String search) {
		return donHangDao.getDonHang(currentPage, perPage, search);
	}

	@Override
	public boolean isDonHangIdUnique(Integer id) {
		DonHang DonHang = findById(id);
		return (DonHang == null || (id != null));
	}
}