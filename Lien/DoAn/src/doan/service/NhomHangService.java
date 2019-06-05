package doan.service;

import java.util.List;

import doan.entity.NhomHang;

public interface NhomHangService {
	NhomHang findById(int id);

	void saveNhomHang(NhomHang NhomHang);

	void updateNhomHang(NhomHang NhomHang);

	void deleteById(int id);

	List<NhomHang> findAllNhomHang();

	List<NhomHang> findAllNhomHang(String search);

	boolean isNhomHangIdUnique(Integer id);

	List<NhomHang> getNhomHang(int fromIndex, int toIndex);

	List<NhomHang> getNhomHang(int fromIndex, int toIndex, String search);
}
