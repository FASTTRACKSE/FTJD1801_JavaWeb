package doan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Client")
public class ClientController {

	@RequestMapping(value = {"","/"})
	public ModelAndView list() {
		return new ModelAndView("redirect:/Client/TrangChu");
	}

}