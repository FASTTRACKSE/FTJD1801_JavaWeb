package doan.service;

import java.util.List;

import doan.entity.DonHang;

public interface DonHangService {
	DonHang findById(int id);

	void saveDonHang(DonHang DonHang);

	void updateDonHang(DonHang DonHang);

	void deleteById(int id);

	List<DonHang> findAllDonHang();

	List<DonHang> findAllDonHang(String search);

	boolean isDonHangIdUnique(Integer id);

	List<DonHang> getDonHang(int fromIndex, int toIndex);

	List<DonHang> getDonHang(int fromIndex, int toIndex, String search);
}