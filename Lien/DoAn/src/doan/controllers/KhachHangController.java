package doan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.KhachHang;
import doan.service.KhachHangService;

@Controller
@RequestMapping("/Admin/QuanLyDuLieu/KhachHang")
public class KhachHangController {
	String tenKhachHang = "";

	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listkhachHang(ModelMap model) {
		int nPage = 1;
		int perPage = 5;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<KhachHang> listAllkhachHang = khachHangService.findAllKhachHang(tenKhachHang);
		if (listAllkhachHang.size() < recordEnd) {
			recordEnd = listAllkhachHang.size();
		}
		List<KhachHang> KhachHang = khachHangService.getKhachHang(currentPage, recordEnd, tenKhachHang);

		int totalPage = (int) Math.ceil((double) listAllkhachHang.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("KhachHang", KhachHang);

		return "admin/QuanLyDuLieu/DSKhachHang/KhachHang";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listkhachHangPaging(ModelMap model, @PathVariable int nPage) {

		int perPage = 5;
		List<KhachHang> listAllkhachHangs = khachHangService.findAllKhachHang();
		int totalPage = (int) Math.ceil((double) listAllkhachHangs.size() / perPage);
		if (nPage < 1) {
			nPage = 1;
		}
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		if (listAllkhachHangs.size() < recordEnd) {
			recordEnd = listAllkhachHangs.size();
		}
		List<KhachHang> KhachHang = khachHangService.getKhachHang(currentPage, recordEnd);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("KhachHang", KhachHang);

		return "admin/QuanLyDuLieu/DSKhachHang/KhachHang";
	}
	
	@RequestMapping(value = { "xoa/{maKhachHang}" }, method = RequestMethod.GET)
	public String huyDon( ModelMap model, @PathVariable int maKhachHang) {
		 
		khachHangService.deleteById(maKhachHang);
	
		return "redirect:/Admin/QuanLykhachHang/DuyetDon";
	}
	
	@RequestMapping(value = { "xem/{makhachHang}" }, method = RequestMethod.GET)
	public String xemDon( ModelMap model, @PathVariable int makhachHang) {
	 
		KhachHang khachHang= khachHangService.findById(makhachHang);
		
		model.addAttribute("KhachHang", khachHang);
		
		return "admin/QuanLyDuLieu/DSKhachHang/xem";
	}
	
}
