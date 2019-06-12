package doan.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import doan.entity.KhachHang;
import doan.service.KhachHangService;

@Controller
@RequestMapping("/Client/Account")
public class LoginController {

	KhachHang user = null;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/" })
	public ModelAndView list() {
		return new ModelAndView("client/account/login");
	}

	@RequestMapping(value = { "Login" }, method = RequestMethod.POST)
	public String login(@PathParam(value = "email") String email, @PathParam(value = "password") String password,
			ModelMap model, HttpSession session) {
		String thongBao;

		if (khachHangService.findAllKhachHang() != null) {
			List<KhachHang> listKhachHang = khachHangService.findAllKhachHang();			

			for (int i = 0; i < listKhachHang.size(); i++) {
				if (listKhachHang.get(i).getUsers().equals(email)) {
					if (listKhachHang.get(i).getMatKhau().equals(password))
						user = listKhachHang.get(i);
				}
			}

		}
		
		if(user == null) {
			thongBao = "Đăng nhập thất bại!!! Sai tài khoản hoặc mật khẩu.";
			model.addAttribute("thongBao", thongBao);
			return "client/account/login";			
		}
		
		model.addAttribute("user", user);
		model.addAttribute("taikhoan", email);
		session.setAttribute("user", user);


		return "redirect:/Client/TrangChu";
	}
}