package doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.dao.NhomHangDao;
import doan.entity.NhomHang;

@Transactional
@Service
public class NhomHangServiceImpl implements NhomHangService {
	@Autowired
	private NhomHangDao nhomHangDao;

	@Override
	public NhomHang findById(int id) {
		return nhomHangDao.findById(id);
	}

	@Override
	public void saveNhomHang(NhomHang NhomHang) {
		nhomHangDao.saveNhomHang(NhomHang);
	}

	@Override
	public void updateNhomHang(NhomHang NhomHang) {
		NhomHang entity = nhomHangDao.findById(NhomHang.getMaNhom());
		if (entity != null) {
			entity.setTenNhom(NhomHang.getTenNhom());
			entity.setGhiChu(NhomHang.getGhiChu());
		}
	}

	@Override
	public void deleteById(int id) {
		nhomHangDao.deleteNhomHangById(id);
	}

	@Override
	public List<NhomHang> findAllNhomHang() {
		return nhomHangDao.findAllNhomHang();
	}

	@Override
	public List<NhomHang> findAllNhomHang(String search) {
		return nhomHangDao.findAllNhomHang(search);
	}

	@Override
	public List<NhomHang> getNhomHang(int currentPage, int perPage) {
		return nhomHangDao.getNhomHang(currentPage, perPage);
	}

	@Override
	public List<NhomHang> getNhomHang(int currentPage, int perPage, String search) {
		return nhomHangDao.getNhomHang(currentPage, perPage, search);
	}

	@Override
	public boolean isNhomHangIdUnique(Integer id) {
		NhomHang NhomHang = findById(id);
		return (NhomHang == null || (id != null));
	}
}