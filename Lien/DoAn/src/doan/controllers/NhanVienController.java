package doan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.NhanVien;
import doan.service.NhanVienService;

@Controller
@RequestMapping("/Admin/QuanLyDuLieu/NhanVien")
public class NhanVienController {
	String tenNhanVien = "";

	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listNhanVien(ModelMap model) {
		int nPage = 1;
		int perPage = 5;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<NhanVien> listAllNhanVien = nhanVienService.findAllNhanVien(tenNhanVien);
		if (listAllNhanVien.size() < recordEnd) {
			recordEnd = listAllNhanVien.size();
		}
		List<NhanVien> NhanVien = nhanVienService.getNhanVien(currentPage, recordEnd, tenNhanVien);

		int totalPage = (int) Math.ceil((double) listAllNhanVien.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("NhanVien", NhanVien);

		return "admin/QuanLyDuLieu/NhanVien";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listNhanVienPaging(ModelMap model, @PathVariable int nPage) {

		int perPage = 5;
		List<NhanVien> listAllNhanViens = nhanVienService.findAllNhanVien();
		int totalPage = (int) Math.ceil((double) listAllNhanViens.size() / perPage);
		if (nPage < 1) {
			nPage = 1;
		}
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		if (listAllNhanViens.size() < recordEnd) {
			recordEnd = listAllNhanViens.size();
		}
		List<NhanVien> NhanVien = nhanVienService.getNhanVien(currentPage, recordEnd);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("NhanVien", NhanVien);

		return "admin/QuanLyDuLieu/NhanVien";
	}

	@RequestMapping(value = { "duyet/{maNhanVien}" }, method = RequestMethod.GET)
	public String duyetDon( ModelMap model, @PathVariable int maNhanVien) {
		 
//		NhanVien NhanVien= nhanVienService.findById(maNhanVien);
//		NhanVien.setTrangThai("Đã duyệt");
//		nhanVienService.updateNhanVien(NhanVien);
		
		return "redirect:/Admin/QuanLyNhanVien/DuyetDon";
	}
	
	@RequestMapping(value = { "huy/{maNhanVien}" }, method = RequestMethod.GET)
	public String huyDon( ModelMap model, @PathVariable int maNhanVien) {
		 
//		NhanVien NhanVien= nhanVienService.findById(maNhanVien);
//		NhanVien.setTrangThai("Đã hủy");
//		nhanVienService.updateNhanVien(NhanVien);
	
		return "redirect:/Admin/QuanLyNhanVien/DuyetDon";
	}
	
	@RequestMapping(value = { "xem/{maNhanVien}" }, method = RequestMethod.GET)
	public String xemDon( ModelMap model, @PathVariable int maNhanVien) {
	 
//		NhanVien NhanVien= nhanVienService.findById(maNhanVien);
//		NhanVien NhanVien = nhanVienService.findById(NhanVien.getMaNhanVien());
//		NhanVien nhanVien = nhanVienService.findById(NhanVien.getMaNhanVien());
//		
//		model.addAttribute("NhanVien", NhanVien);
//		model.addAttribute("NhanVien", NhanVien);
//		model.addAttribute("nhanVien", nhanVien);
		
		return "admin/QuanLyNhanVien/NhanVien";
	}
	
}
