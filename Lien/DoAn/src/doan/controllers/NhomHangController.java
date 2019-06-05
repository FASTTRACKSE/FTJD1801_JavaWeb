package doan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.NhomHang;
import doan.service.NhomHangService;

@Controller
@RequestMapping("/Admin/QuanLyDuLieu/NhomHang")
public class NhomHangController {
	String tenNhomHang = "";

	@Autowired
	NhomHangService nhomHangService;
	
	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listNhomHang(ModelMap model) {
		int nPage = 1;
		int perPage = 5;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<NhomHang> listAllNhomHang = nhomHangService.findAllNhomHang(tenNhomHang);
		if (listAllNhomHang.size() < recordEnd) {
			recordEnd = listAllNhomHang.size();
		}
		List<NhomHang> NhomHang = nhomHangService.getNhomHang(currentPage, recordEnd, tenNhomHang);

		int totalPage = (int) Math.ceil((double) listAllNhomHang.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("NhomHang", NhomHang);

		return "admin/QuanLyDuLieu/NhomHang";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listNhomHangPaging(ModelMap model, @PathVariable int nPage) {

		int perPage = 5;
		List<NhomHang> listAllNhomHangs = nhomHangService.findAllNhomHang();
		int totalPage = (int) Math.ceil((double) listAllNhomHangs.size() / perPage);
		if (nPage < 1) {
			nPage = 1;
		}
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		if (listAllNhomHangs.size() < recordEnd) {
			recordEnd = listAllNhomHangs.size();
		}
		List<NhomHang> NhomHang = nhomHangService.getNhomHang(currentPage, recordEnd);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("NhomHang", NhomHang);

		return "admin/QuanLyDuLieu/NhomHang";
	}

	@RequestMapping(value = { "duyet/{maNhomHang}" }, method = RequestMethod.GET)
	public String duyetDon( ModelMap model, @PathVariable int maNhomHang) {
		 
//		NhomHang NhomHang= nhomHangService.findById(maNhomHang);
//		NhomHang.setTrangThai("Đã duyệt");
//		nhomHangService.updateNhomHang(NhomHang);
		
		return "redirect:/Admin/QuanLyNhomHang/DuyetDon";
	}
	
	@RequestMapping(value = { "huy/{maNhomHang}" }, method = RequestMethod.GET)
	public String huyDon( ModelMap model, @PathVariable int maNhomHang) {
		 
//		NhomHang NhomHang= nhomHangService.findById(maNhomHang);
//		NhomHang.setTrangThai("Đã hủy");
//		nhomHangService.updateNhomHang(NhomHang);
	
		return "redirect:/Admin/QuanLyNhomHang/DuyetDon";
	}
	
	@RequestMapping(value = { "xem/{maNhomHang}" }, method = RequestMethod.GET)
	public String xemDon( ModelMap model, @PathVariable int maNhomHang) {
	 
//		NhomHang NhomHang= nhomHangService.findById(maNhomHang);
//		NhomHang NhomHang = nhomHangService.findById(NhomHang.getMaNhomHang());
//		NhomHang NhomHang = nhomHangService.findById(NhomHang.getMaNhomHang());
//		
//		model.addAttribute("NhomHang", NhomHang);
//		model.addAttribute("NhomHang", NhomHang);
//		model.addAttribute("NhomHang", NhomHang);
		
		return "admin/QuanLyNhomHang/NhomHang";
	}
	
}
