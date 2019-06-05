package doan.service;

import java.util.List;

import doan.entity.ChiTietDonHang;

public interface ChiTietDonHangService {
	ChiTietDonHang findById(int id);

	void saveChiTietDonHang(ChiTietDonHang ChiTietDonHang);

	void updateChiTietDonHang(ChiTietDonHang ChiTietDonHang);

	void deleteById(int id);

	List<ChiTietDonHang> findAllChiTietDonHang();

	List<ChiTietDonHang> findAllChiTietDonHang(String search);

	boolean isChiTietDonHangIdUnique(Integer id);

	List<ChiTietDonHang> getChiTietDonHang(int fromIndex, int toIndex);

	List<ChiTietDonHang> getChiTietDonHang(int fromIndex, int toIndex, String search);
}