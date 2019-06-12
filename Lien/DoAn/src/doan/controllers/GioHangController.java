package doan.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
@RequestMapping("/Client/GioHang")
public class GioHangController {
	ArrayList<HangHoa> gioHang = new ArrayList<HangHoa>();
	int countCart = 0;
	int tongTien = 0;

	@Autowired
	HangHoaService hangHoaService;

	@Autowired
	MessageSource message;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/XemGio" }, method = RequestMethod.GET)
	public String xemGioHang(ModelMap model, HttpSession session) {
		tongTien = 0;
		countCart = 0;
		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");
		HangHoa hangHoa = new HangHoa();
		
		if (gioHang != null) {
			for (int i = 0; i < gioHang.size(); i++) {
				tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
			}
			countCart = gioHang.size();
		}
		model.addAttribute("hangHoa", hangHoa);
		model.addAttribute("countCart", countCart);
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("gioHang", gioHang);
		session.setAttribute("gioHang", gioHang);

		return "client/QLGioHang/GioHang";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/XemGio" }, method = RequestMethod.POST)
	public String xemGioHang(ModelMap model, HttpSession session, @Valid HangHoa hangHoa) {

		
		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");
		for (int i = 0; i < gioHang.size(); i++) {
			if (gioHang.get(i).getMaHang() == hangHoa.getMaHang()) {
				gioHang.get(i).setSoLuong(hangHoa.getSoLuong());
			}
		}

		session.setAttribute("gioHang", gioHang);

		return "redirect:/Client/GioHang/XemGio";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "xoa/{maHang}" }, method = RequestMethod.GET)
	public String xoaKhoiGio(ModelMap model, @PathVariable int maHang, HttpSession session) {	
		
		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");
		
		for(int i = 0; i < gioHang.size(); i++) {
			if(gioHang.get(i).getMaHang() == maHang) {
				gioHang.remove(i);
			}
		}
		
		session.setAttribute("gioHang", gioHang);

		return "redirect:/Client/GioHang/XemGio";
	}

}
