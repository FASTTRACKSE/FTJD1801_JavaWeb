package doan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.DonHang;
import doan.entity.KhachHang;
import doan.entity.NhanVien;
import doan.service.DonHangService;
import doan.service.KhachHangService;
import doan.service.NhanVienService;

@Controller
@RequestMapping("/Admin/QuanLyDonHang/DuyetDon")
public class DonHangController {
	String trangThaiChon = "";

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	DonHangService donHangService;
	
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listDonHang(ModelMap model) {
		int nPage = 1;
		int perPage = 5;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<DonHang> listAllDonHang = donHangService.findAllDonHang(trangThaiChon);
		if (listAllDonHang.size() < recordEnd) {
			recordEnd = listAllDonHang.size();
		}
		List<DonHang> DonHang = donHangService.getDonHang(currentPage, recordEnd, trangThaiChon);

		int totalPage = (int) Math.ceil((double) listAllDonHang.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("DonHang", DonHang);

		return "admin/QuanLyDonHang/ListDuyet";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listDonHangPaging(ModelMap model, @PathVariable int nPage) {

		int perPage = 5;
		List<DonHang> listAllDonHangs = donHangService.findAllDonHang();
		int totalPage = (int) Math.ceil((double) listAllDonHangs.size() / perPage);
		if (nPage < 1) {
			nPage = 1;
		}
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		if (listAllDonHangs.size() < recordEnd) {
			recordEnd = listAllDonHangs.size();
		}
		List<DonHang> DonHang = donHangService.getDonHang(currentPage, recordEnd);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("DonHang", DonHang);

		return "admin/QuanLyDonHang/ListDuyet";
	}

	@RequestMapping(value = { "duyet/{maDonHang}" }, method = RequestMethod.GET)
	public String duyetDon( ModelMap model, @PathVariable int maDonHang) {
//		 
		DonHang donHang= donHangService.findById(maDonHang);
		donHang.setTrangThai("Đã duyệt");
		donHangService.updateDonHang(donHang);
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	
	@RequestMapping(value = { "huy/{maDonHang}" }, method = RequestMethod.GET)
	public String huyDon( ModelMap model, @PathVariable int maDonHang) {
//		 
		DonHang donHang= donHangService.findById(maDonHang);
		donHang.setTrangThai("Đã hủy");
		donHangService.updateDonHang(donHang);
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	
	@RequestMapping(value = { "xem/{maDonHang}" }, method = RequestMethod.GET)
	public String xemDon( ModelMap model, @PathVariable int maDonHang) {
//		 
		DonHang donHang= donHangService.findById(maDonHang);
		KhachHang khachHang = khachHangService.findById(donHang.getMaKhachHang());
		NhanVien nhanVien = nhanVienService.findById(donHang.getMaNhanVien());
		
		model.addAttribute("donHang", donHang);
		model.addAttribute("khachHang", khachHang);
		model.addAttribute("nhanVien", nhanVien);
		
		return "admin/QuanLyDonHang/DonHang";
	}
	
	@RequestMapping(value = { "TatCaDon" }, method = RequestMethod.GET)
	public String tatCaDon() {
//		 
		trangThaiChon = "";
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	
	@RequestMapping(value = { "DonDaDuyet" }, method = RequestMethod.GET)
	public String donDaDuyet() {
//		 
		trangThaiChon = "Đã duyệt";
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	
	@RequestMapping(value = { "DonChuaDuyet" }, method = RequestMethod.GET)
	public String donChuaDuyet() {
//		 
		trangThaiChon = "Chưa duyệt";
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	
	@RequestMapping(value = { "DonDangGiao" }, method = RequestMethod.GET)
	public String donDangGiao() {
//		 
		trangThaiChon = "Đang giao";
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	@RequestMapping(value = { "DonDaGiao" }, method = RequestMethod.GET)
	public String donDaGiao() {
//		 
		trangThaiChon = "Đã giao";
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
	@RequestMapping(value = { "DonDaHuy" }, method = RequestMethod.GET)
	public String donDaHuy() {
//		 
		trangThaiChon = "Đã hủy";
		
		return "redirect:/Admin/QuanLyDonHang/DuyetDon";
	}
}
