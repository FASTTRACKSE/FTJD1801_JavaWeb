package doan.dao;

import java.util.List;

import doan.entity.ChiTietDonHang;

public interface ChiTietDonHangDao {
	ChiTietDonHang findById(int id);

	void saveChiTietDonHang(ChiTietDonHang ChiTietDonHang);

	void deleteChiTietDonHangById(int id);

	List<ChiTietDonHang> findAllChiTietDonHang();

	List<ChiTietDonHang> findAllChiTietDonHang(String search);

	List<ChiTietDonHang> getChiTietDonHang(int fromIndex, int toIndex);

	List<ChiTietDonHang> getChiTietDonHang(int fromIndex, int toIndex, String search);
}