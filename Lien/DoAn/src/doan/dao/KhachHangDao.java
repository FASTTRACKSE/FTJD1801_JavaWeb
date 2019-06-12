package doan.dao;

import java.util.List;

import doan.entity.KhachHang;

public interface KhachHangDao {
	KhachHang findById(int id);

	void saveKhachHang(KhachHang KhachHang);

	void deleteKhachHangById(int id);

	List<KhachHang> findAllKhachHang();

	List<KhachHang> findAllKhachHang(String search);

	List<KhachHang> getKhachHang(int fromIndex, int toIndex);

	List<KhachHang> getKhachHang(int fromIndex, int toIndex, String search);
}