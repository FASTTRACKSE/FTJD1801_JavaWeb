package doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.dao.NhanVienDao;
import doan.entity.NhanVien;

@Transactional
@Service
public class NhanVienServiceImpl implements NhanVienService {
	@Autowired
	private NhanVienDao nhanVienDao;

	@Override
	public NhanVien findById(int id) {
		return nhanVienDao.findById(id);
	}

	@Override
	public void saveNhanVien(NhanVien NhanVien) {
		nhanVienDao.saveNhanVien(NhanVien);
	}

	@Override
	public void updateNhanVien(NhanVien NhanVien) {
		NhanVien entity = nhanVienDao.findById(NhanVien.getMaNhanVien());
		if (entity != null) {
			entity.setTenNhanVien(NhanVien.getTenNhanVien());;
			entity.setChucVu(NhanVien.getChucVu());
			entity.setSoDienThoai(NhanVien.getSoDienThoai());
			entity.setGioiTinh(NhanVien.getGioiTinh());
			entity.setUsers(NhanVien.getUsers());
			entity.setMatKhau(NhanVien.getMatKhau());
		}
	}

	@Override
	public void deleteById(int id) {
		nhanVienDao.deleteNhanVienById(id);
	}

	@Override
	public List<NhanVien> findAllNhanVien() {
		return nhanVienDao.findAllNhanVien();
	}

	@Override
	public List<NhanVien> findAllNhanVien(String search) {
		return nhanVienDao.findAllNhanVien(search);
	}

	@Override
	public List<NhanVien> getNhanVien(int currentPage, int perPage) {
		return nhanVienDao.getNhanVien(currentPage, perPage);
	}

	@Override
	public List<NhanVien> getNhanVien(int currentPage, int perPage, String search) {
		return nhanVienDao.getNhanVien(currentPage, perPage, search);
	}

	@Override
	public boolean isNhanVienIdUnique(Integer id) {
		NhanVien NhanVien = findById(id);
		return (NhanVien == null || (id != null));
	}
}