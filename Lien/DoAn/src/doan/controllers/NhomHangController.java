package doan.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.NhomHang;
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

		return "admin/QuanLyDuLieu/DSNhomHang/NhomHang";
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

		return "admin/QuanLyDuLieu/DSNhomHang/NhomHang";
	}

	@RequestMapping(value = { "them" }, method = RequestMethod.GET)
	public String themNhomHang(ModelMap model) {

		NhomHang nhomHang = new NhomHang();

		model.addAttribute("nhomHang", nhomHang);
		model.addAttribute("edit", false);
		return "admin/QuanLyDuLieu/DSNhomHang/ThemNhomHang";
	}

	@RequestMapping(value = { "them" }, method = RequestMethod.POST)
	public String themNhomHang(ModelMap model, @Valid NhomHang nhomHang, BindingResult result) {

		nhomHangService.saveNhomHang(nhomHang);

		return "redirect:/Admin/QuanLyDuLieu/NhomHang";
	}

	@RequestMapping(value = { "sua/{maNhomHang}" }, method = RequestMethod.GET)
	public String duyetDon(ModelMap model, @PathVariable int maNhomHang) {

		NhomHang nhomHang = nhomHangService.findById(maNhomHang);
		model.addAttribute("nhomHang", nhomHang);
		model.addAttribute("edit", true);

		return "admin/QuanLyDuLieu/DSNhomHang/ThemNhomHang";
	}

	@RequestMapping(value = { "sua/{maNhomHang}" }, method = RequestMethod.POST)
	public String duyetDon(ModelMap model, @Valid NhomHang nhomHang, BindingResult result) {

		nhomHangService.updateNhomHang(nhomHang);

		return "redirect:/Admin/QuanLyDuLieu/NhomHang";
	}

	@RequestMapping(value = { "xoa/{maNhomHang}" }, method = RequestMethod.GET)
	public String huyDon(ModelMap model, @PathVariable int maNhomHang) {

		nhomHangService.deleteById(maNhomHang);

		return "redirect:/Admin/QuanLyDuLieu/NhomHang";
	}

	@RequestMapping(value = { "xem/{maNhomHang}" }, method = RequestMethod.GET)
	public String xemDon(ModelMap model, @PathVariable int maNhomHang) {

		NhomHang NhomHang = nhomHangService.findById(maNhomHang);

		model.addAttribute("nhomHang", NhomHang);

		return "admin/QuanLyDuLieu/DSNhomHang/XemNhomHang";
	}
	
}
