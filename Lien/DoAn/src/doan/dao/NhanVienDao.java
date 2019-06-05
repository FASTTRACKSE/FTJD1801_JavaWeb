package doan.dao;

import java.util.List;

import doan.entity.NhanVien;

public interface NhanVienDao {
	NhanVien findById(int id);

	void saveNhanVien(NhanVien NhanVien);

	void deleteNhanVienById(int id);

	List<NhanVien> findAllNhanVien();

	List<NhanVien> findAllNhanVien(String search);

	List<NhanVien> getNhanVien(int fromIndex, int toIndex);

	List<NhanVien> getNhanVien(int fromIndex, int toIndex, String search);
}