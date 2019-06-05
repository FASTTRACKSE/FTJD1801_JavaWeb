package doan.service;

import java.util.List;

import doan.entity.NhanVien;

public interface NhanVienService {
	NhanVien findById(int id);

	void saveNhanVien(NhanVien NhanVien);

	void updateNhanVien(NhanVien NhanVien);

	void deleteById(int id);

	List<NhanVien> findAllNhanVien();

	List<NhanVien> findAllNhanVien(String search);

	boolean isNhanVienIdUnique(Integer id);

	List<NhanVien> getNhanVien(int fromIndex, int toIndex);

	List<NhanVien> getNhanVien(int fromIndex, int toIndex, String search);
}