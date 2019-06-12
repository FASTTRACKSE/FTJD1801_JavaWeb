package doan.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.ChiTietDonHang;
import doan.entity.ChiTietDonHangId;
import doan.entity.DonHang;
import doan.entity.HangHoa;
import doan.entity.KhachHang;
import doan.service.ChiTietDonHangService;
import doan.service.DonHangService;
import doan.service.HangHoaService;
import doan.service.KhachHangService;

@Controller
@RequestMapping("/Client/DatHang")
public class DatHangController {
	ArrayList<HangHoa> gioHang = new ArrayList<HangHoa>();
	int countCart = 0;
	int tongTien = 0;

	@Autowired
	DonHangService donHangService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	ChiTietDonHangService chiTietDonHangService;

	@Autowired
	HangHoaService hangHoaService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String datHang(ModelMap model, HttpSession session) {
		tongTien = 0;
		countCart = 0;
		DonHang donHang = new DonHang();
		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");
		if (gioHang != null) {
			for (int i = 0; i < gioHang.size(); i++) {
				tongTien = tongTien + gioHang.get(i).getDonGia() * gioHang.get(i).getSoLuong();
			}
			countCart = gioHang.size();
		}

		model.addAttribute("donHang", donHang);
		model.addAttribute("gioHang", gioHang);
		session.setAttribute("gioHang", gioHang);
		session.setAttribute("countCart", countCart);
		session.setAttribute("tongTien", tongTien);
		session.setAttribute("tongThanhTien", tongTien + 30000 + tongTien / 10);

		return "client/QLGioHang/DatHang";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public String datHang(ModelMap model, HttpSession session, @Valid DonHang donHang) {
		Date dayNow = new Date();
		int pointTich = 0;
		int tongThanhTien = (int) session.getAttribute("tongThanhTien");
		int point = (int) session.getAttribute("point");
		KhachHang user = (KhachHang) session.getAttribute("user");
		gioHang = (ArrayList<HangHoa>) session.getAttribute("gioHang");

		donHang.setMaKhachHang(user.getMaKhachHang());
		donHang.setNgayDatHang(dayNow);
		donHang.setTongThanhTien(tongThanhTien);
		donHang.setGiamGia(point * 1000);

		donHangService.saveDonHang(donHang);

		List<DonHang> listDonHang = donHangService.findAllDonHang();
		DonHang donHang2 = listDonHang.get(listDonHang.size() - 1);

		for (int i = 0; i < gioHang.size(); i++) {
			HangHoa hangHoa = new HangHoa();
			hangHoa = hangHoaService.findById(gioHang.get(i).getMaHang());
			hangHoa.setSoLuong(hangHoa.getSoLuong()-gioHang.get(i).getSoLuong());
			hangHoaService.updateHangHoa(hangHoa);
			
			ChiTietDonHangId chiTietId = new ChiTietDonHangId();
			chiTietId.setMaDonHang(donHang2.getMaDonHang());
			chiTietId.setMaHang(gioHang.get(i).getMaHang());
			ChiTietDonHang chiTiet = new ChiTietDonHang();
			chiTiet.setId(chiTietId);
			chiTiet.setSoLuong(gioHang.get(i).getSoLuong());
			chiTiet.setDonGia(gioHang.get(i).getDonGia());
			chiTiet.setGhiChu("");
			chiTietDonHangService.saveChiTietDonHang(chiTiet);
		}

		pointTich = tongThanhTien / 10000 - point;
		KhachHang khachHang = khachHangService.findById(user.getMaKhachHang());
		KhachHang khachHangPoint = new KhachHang();
		khachHangPoint = khachHang;
		int pointOld = khachHangPoint.getPoint();
		khachHangPoint.setPoint(pointOld + pointTich);

		khachHangService.updateKhachHang(khachHangPoint);

		gioHang = null;
		session.setAttribute("gioHang", gioHang);

		return "redirect:/Client/DatHang";
	}

	@RequestMapping(value = { "updatePoint" }, method = RequestMethod.POST)
	public String updatePoint(HttpSession session, @PathParam(value = "point") int point, ModelMap model) {
		int pointSet = point;
		KhachHang user = (KhachHang) session.getAttribute("user");
		int tongTien = (int) session.getAttribute("tongTien");

		if (pointSet > user.getPoint()) {
			String loiPoint = "Điểm tích lũy của bạn không đủ!";
			session.setAttribute("loiPoint", loiPoint);
			session.setAttribute("point", 0);
			return "redirect:/Client/DatHang";
		}

		if (pointSet * 1000 > tongTien / 2) {
			String loiPoint = "Bạn chỉ có thể dùng điểm tích lũy giảm thấp hơn 50% tổng chi phí hóa đơn!";
			session.setAttribute("loiPoint", loiPoint);
			session.setAttribute("point", 0);
			return "redirect:/Client/DatHang";
		}

		String loiPoint = "";
		session.setAttribute("loiPoint", loiPoint);
		session.setAttribute("point", pointSet);

		return "redirect:/Client/DatHang";
	}
}
