package doan.dao;

import java.util.List;

import doan.entity.DonHang;

public interface DonHangDao {
	DonHang findById(int id);

	void saveDonHang(DonHang DonHang);

	void deleteDonHangById(int id);

	List<DonHang> findAllDonHang();

	List<DonHang> findAllDonHang(String search);

	List<DonHang> getDonHang(int fromIndex, int toIndex);

	List<DonHang> getDonHang(int fromIndex, int toIndex, String search);
}