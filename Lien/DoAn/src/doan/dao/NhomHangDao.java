package doan.dao;

import java.util.List;

import doan.entity.NhomHang;

public interface NhomHangDao {
	NhomHang findById(int id);

	void saveNhomHang(NhomHang NhomHang);

	void deleteNhomHangById(int id);

	List<NhomHang> findAllNhomHang();

	List<NhomHang> findAllNhomHang(String search);

	List<NhomHang> getNhomHang(int fromIndex, int toIndex);

	List<NhomHang> getNhomHang(int fromIndex, int toIndex, String search);
}
