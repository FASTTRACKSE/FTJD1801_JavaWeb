package doan.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.HangHoa;
import doan.service.HangHoaService;

@Controller
@RequestMapping("/Client/TrangChu")
public class TrangChuController {

	ArrayList<HangHoa> gioHang = new ArrayList<HangHoa>();
	int countCart = 0;
	int tongTien = 0;

	@Autowired
	HangHoaService hangHoaService;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listHangHoa(ModelMap model) {
		tongTien = 0;
		int nPage = 1;
		int perPage = 12;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<HangHoa> listAllHangHoa = hangHoaService.findAllHangHoa();
		if (listAllHangHoa.size() < recordEnd) {
			recordEnd = listAllHangHoa.size();
		}
		List<HangHoa> HangHoa = hangHoaService.getHangHoa(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllHangHoa.size() / perPage);
		
		for (int i = 0; i < gioHang.size(); i++) {
			tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
		}
		countCart = gioHang.size();

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("HangHoa", HangHoa);
		model.addAttribute("countCart", countCart);
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("gioHang", gioHang);

		return "client/TrangChu";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listHangHoaPaging(ModelMap model, @PathVariable int nPage) {
		tongTien = 0;
		int perPage = 12;
		List<HangHoa> listAllHangHoas = hangHoaService.findAllHangHoa();
		int totalPage = (int) Math.ceil((double) listAllHangHoas.size() / perPage);
		if (nPage < 1) {
			nPage = 1;
		}
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		if (listAllHangHoas.size() < recordEnd) {
			recordEnd = listAllHangHoas.size();
		}
		List<HangHoa> HangHoa = hangHoaService.getHangHoa(currentPage, recordEnd);
		
		for (int i = 0; i < gioHang.size(); i++) {
			tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
		}
		countCart = gioHang.size();

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("HangHoa", HangHoa);
		model.addAttribute("countCart", countCart);
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("gioHang", gioHang);

		return "client/TrangChu";
	}

	@RequestMapping(value = { "ThemVaoGio/{maHang}" }, method = RequestMethod.GET)
	public String themVaoGio(ModelMap model, @PathVariable int maHang, HttpSession session) {
		
		tongTien = 0;
		int dem = 0;
		HangHoa hangHoa = hangHoaService.findById(maHang);
		hangHoa.setSoLuong(1);
		if (gioHang.size() == 0) {
			gioHang.add(hangHoa);
		} else {
			for (int i = 0; i < gioHang.size(); i++) {
				if (gioHang.get(i).getMaHang() == maHang) {
					gioHang.get(i).setSoLuong(gioHang.get(i).getSoLuong() + 1);
					dem = dem + 1;
					break;
				}			
			}
			if (dem == 0) {
				gioHang.add(hangHoa);
			}
		}
		for (int i = 0; i < gioHang.size(); i++) {
			tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
		}
		countCart = gioHang.size();
		session.setAttribute("gioHang", gioHang);

		return "redirect:/Client/TrangChu/list/1";
	}
	
	@RequestMapping(value = { "XoaKhoiGio/{maHang}" }, method = RequestMethod.GET)
	public String xoaKhoiGio(ModelMap model, @PathVariable int maHang, HttpSession session) {
		
		tongTien = 0;
		for(int i = 0; i < gioHang.size(); i++) {
			if(gioHang.get(i).getMaHang() == maHang) {
				gioHang.remove(i);
			}
		}
		for (int i = 0; i < gioHang.size(); i++) {
			tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
		}
		countCart = gioHang.size();
		
		session.setAttribute("gioHang", gioHang);

		return "redirect:/Client/TrangChu/list/1";
	}
}