package doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.dao.ChiTietDonHangDao;
import doan.entity.ChiTietDonHang;

@Transactional
@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService {
	@Autowired
	private ChiTietDonHangDao chiTietDonHangImpl;

	@Override
	public ChiTietDonHang findById(int id) {
		return chiTietDonHangImpl.findById(id);
	}

	@Override
	public void saveChiTietDonHang(ChiTietDonHang ChiTietDonHang) {
		chiTietDonHangImpl.saveChiTietDonHang(ChiTietDonHang);
	}

	@Override
	public void updateChiTietDonHang(ChiTietDonHang ChiTietDonHang) {
		
	}

	@Override
	public void deleteById(int id) {
		chiTietDonHangImpl.deleteChiTietDonHangById(id);
	}

	@Override
	public List<ChiTietDonHang> findAllChiTietDonHang() {
		return chiTietDonHangImpl.findAllChiTietDonHang();
	}

	@Override
	public List<ChiTietDonHang> findAllChiTietDonHang(String search) {
		return chiTietDonHangImpl.findAllChiTietDonHang(search);
	}

	@Override
	public List<ChiTietDonHang> getChiTietDonHang(int currentPage, int perPage) {
		return chiTietDonHangImpl.getChiTietDonHang(currentPage, perPage);
	}

	@Override
	public List<ChiTietDonHang> getChiTietDonHang(int currentPage, int perPage, String search) {
		return chiTietDonHangImpl.getChiTietDonHang(currentPage, perPage, search);
	}

	@Override
	public boolean isChiTietDonHangIdUnique(Integer id) {
		ChiTietDonHang ChiTietDonHang = findById(id);
		return (ChiTietDonHang == null || (id != null));
	}
}