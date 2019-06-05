package doan.service;

import java.util.List;

import doan.entity.HangHoa;

public interface HangHoaService {
	HangHoa findById(int id);

	void saveHangHoa(HangHoa HangHoa);

	void updateHangHoa(HangHoa HangHoa);

	void deleteById(int id);

	List<HangHoa> findAllHangHoa();

	List<HangHoa> findAllHangHoa(String search);

	boolean isHangHoaIdUnique(Integer id);

	List<HangHoa> getHangHoa(int fromIndex, int toIndex);

	List<HangHoa> getHangHoa(int fromIndex, int toIndex, String search);
}