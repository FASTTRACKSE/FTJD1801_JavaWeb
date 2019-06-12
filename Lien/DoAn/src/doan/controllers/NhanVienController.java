package doan.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

	@RequestMapping(value = { "search" }, method = RequestMethod.POST)
	public String search(ModelMap model, @PathParam(value = "searchName") String searchName) {

		tenNhanVien = searchName;

		return "redirect:/Admin/QuanLyDuLieu/NhanVien/list/1";
	}

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listNhanVien(ModelMap model) {
		int nPage = 1;
		int perPage = 5;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<NhanVien> listAllNhanVien = nhanVienService.findAllNhanVien();
		if (listAllNhanVien.size() < recordEnd) {
			recordEnd = listAllNhanVien.size();
		}
		List<NhanVien> NhanVien = nhanVienService.getNhanVien(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllNhanVien.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("NhanVien", NhanVien);

		return "admin/QuanLyDuLieu/DSNhanVien/NhanVien";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listNhanVienPaging(ModelMap model, @PathVariable int nPage) {

		if (nhanVienService.findAllNhanVien(tenNhanVien).size() == 0) {
			return "admin/QuanLyDuLieu/DSNhanVien/NhanVien";
		}
		int perPage = 5;
		List<NhanVien> listAllNhanViens = nhanVienService.findAllNhanVien(tenNhanVien);
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
		List<NhanVien> NhanVien = nhanVienService.getNhanVien(currentPage, recordEnd, tenNhanVien);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("NhanVien", NhanVien);
		model.addAttribute("searchValue", tenNhanVien);

		return "admin/QuanLyDuLieu/DSNhanVien/NhanVien";
	}

	@RequestMapping(value = { "them" }, method = RequestMethod.GET)
	public String themNhanVien(ModelMap model) {

		NhanVien nhanVien = new NhanVien();

		model.addAttribute("nhanVien", nhanVien);
		model.addAttribute("edit", false);
		return "admin/QuanLyDuLieu/DSNhanVien/ThemNhanVien";
	}

	@RequestMapping(value = { "them" }, method = RequestMethod.POST)
	public String themNhanVien(ModelMap model, @Valid NhanVien nhanVien, BindingResult result) {

		nhanVienService.saveNhanVien(nhanVien);

		return "redirect:/Admin/QuanLyDuLieu/NhanVien";
	}

	@RequestMapping(value = { "sua/{maNhanVien}" }, method = RequestMethod.GET)
	public String duyetDon(ModelMap model, @PathVariable int maNhanVien) {

		NhanVien nhanVien = nhanVienService.findById(maNhanVien);
		model.addAttribute("nhanVien", nhanVien);
		model.addAttribute("edit", true);

		return "admin/QuanLyDuLieu/DSNhanVien/ThemNhanVien";
	}

	@RequestMapping(value = { "sua/{maNhanVien}" }, method = RequestMethod.POST)
	public String duyetDon(ModelMap model, @Valid NhanVien nhanVien, BindingResult result) {

		nhanVienService.updateNhanVien(nhanVien);

		return "redirect:/Admin/QuanLyDuLieu/NhanVien";
	}

	@RequestMapping(value = { "xoa/{maNhanVien}" }, method = RequestMethod.GET)
	public String huyDon(ModelMap model, @PathVariable int maNhanVien) {

		nhanVienService.deleteById(maNhanVien);

		return "redirect:/Admin/QuanLyDuLieu/NhanVien";
	}

	@RequestMapping(value = { "xem/{maNhanVien}" }, method = RequestMethod.GET)
	public String xemDon(ModelMap model, @PathVariable int maNhanVien) {

		NhanVien NhanVien = nhanVienService.findById(maNhanVien);

		model.addAttribute("nhanVien", NhanVien);

		return "admin/QuanLyDuLieu/DSNhanVien/XemNhanVien";
	}

}
