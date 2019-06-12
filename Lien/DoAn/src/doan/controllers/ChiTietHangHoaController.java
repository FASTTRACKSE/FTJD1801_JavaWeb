package doan.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.HangHoa;
import doan.service.HangHoaService;

@Controller
@RequestMapping("/Client/ChiTietHang")
public class ChiTietHangHoaController {
	ArrayList<HangHoa> gioHang = new ArrayList<HangHoa>();
	int countCart = 0;
	int tongTien = 0;

	@Autowired
	HangHoaService hangHoaService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "xem/{maHang}" }, method = RequestMethod.GET)
	public String xemChiTietHang(ModelMap model, HttpSession session, @PathVariable int maHang) {
		tongTien = 0;
		countCart = 0;
		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");

		HangHoa hangHoa = new HangHoa();
		HangHoa hangHoaNull = new HangHoa();
		hangHoa = hangHoaService.findById(maHang);
	
		if (gioHang != null) {
			for (int i = 0; i < gioHang.size(); i++) {
				tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
			}
			countCart = gioHang.size();
		}
		model.addAttribute("hangHoa", hangHoa);
		model.addAttribute("hangHoaNull", hangHoaNull);
		model.addAttribute("countCart", countCart);
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("gioHang", gioHang);
		session.setAttribute("gioHang", gioHang);

		return "client/ChiTietSanPham/ChiTietSanPham";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "xem/{maHang}" }, method = RequestMethod.POST)
	public String xemChiTietHang(ModelMap model, HttpSession session, @Valid HangHoa hangHoaNull) {
		int dem = 0;

		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");
		if (gioHang != null) {
			for (int i = 0; i < gioHang.size(); i++) {
				if (gioHang.get(i).getMaHang() == hangHoaNull.getMaHang()) {
					gioHang.get(i).setSoLuong(hangHoaNull.getSoLuong());
					dem++;
				}
			} 
		}
		if (dem == 0) {
			HangHoa hangHoaTam = hangHoaService.findById(hangHoaNull.getMaHang());
			hangHoaTam.setSoLuong(hangHoaNull.getSoLuong());
			gioHang.add(hangHoaTam);
		}

		session.setAttribute("gioHang", gioHang);

		return "redirect:/Client/ChiTietHang/xem/" + hangHoaNull.getMaHang() + "";
	}
}
