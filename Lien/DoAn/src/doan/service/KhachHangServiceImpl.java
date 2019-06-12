package doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.dao.KhachHangDao;
import doan.entity.KhachHang;

@Transactional
@Service
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	private KhachHangDao khachHangDao;

	@Override
	public KhachHang findById(int id) {
		return khachHangDao.findById(id);
	}

	@Override
	public void saveKhachHang(KhachHang KhachHang) {
		khachHangDao.saveKhachHang(KhachHang);
	}

	@Override
	public void updateKhachHang(KhachHang KhachHang) {
		KhachHang entity = khachHangDao.findById(KhachHang.getMaKhachHang());
		if (entity != null) {
			entity.setTenKhachHang(KhachHang.getTenKhachHang());
			entity.setEmail(KhachHang.getEmail());
			entity.setSoDienThoai(KhachHang.getSoDienThoai());
			entity.setGioiTinh(KhachHang.getGioiTinh());
			entity.setNgaySinh(KhachHang.getNgaySinh());
			entity.setUsers(KhachHang.getUsers());
			entity.setMatKhau(KhachHang.getMatKhau());
			entity.setDiaChi(KhachHang.getDiaChi());
			entity.setPoint(KhachHang.getPoint());
		}
	}

	@Override
	public void deleteById(int id) {
		khachHangDao.deleteKhachHangById(id);
	}

	@Override
	public List<KhachHang> findAllKhachHang() {
		return khachHangDao.findAllKhachHang();
	}

	@Override
	public List<KhachHang> findAllKhachHang(String search) {
		return khachHangDao.findAllKhachHang(search);
	}

	@Override
	public List<KhachHang> getKhachHang(int currentPage, int perPage) {
		return khachHangDao.getKhachHang(currentPage, perPage);
	}

	@Override
	public List<KhachHang> getKhachHang(int currentPage, int perPage, String search) {
		return khachHangDao.getKhachHang(currentPage, perPage, search);
	}

	@Override
	public boolean isKhachHangIdUnique(Integer id) {
		KhachHang KhachHang = findById(id);
		return (KhachHang == null || (id != null));
	}
}