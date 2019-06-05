package doan.dao;

import java.util.List;

import doan.entity.HangHoa;

public interface HangHoaDao {
	HangHoa findById(int id);

	void saveHangHoa(HangHoa hanghoa);

	void deleteHangHoaById(int id);

	List<HangHoa> findAllHangHoa();

	List<HangHoa> findAllHangHoa(String search);

	List<HangHoa> getHangHoa(int fromIndex, int toIndex);

	List<HangHoa> getHangHoa(int fromIndex, int toIndex, String search);
}