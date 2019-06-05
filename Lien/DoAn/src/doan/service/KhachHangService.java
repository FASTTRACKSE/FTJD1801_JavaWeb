package doan.service;

import java.util.List;

import doan.entity.KhachHang;

public interface KhachHangService {
	KhachHang findById(int id);

	void saveKhachHang(KhachHang KhachHang);

	void updateKhachHang(KhachHang KhachHang);

	void deleteById(int id);
	
	KhachHang login(String userEmail, String userPass);

	List<KhachHang> findAllKhachHang();

	List<KhachHang> findAllKhachHang(String search);

	boolean isKhachHangIdUnique(Integer id);

	List<KhachHang> getKhachHang(int fromIndex, int toIndex);

	List<KhachHang> getKhachHang(int fromIndex, int toIndex, String search);
}