package quanlysinhvien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import quanlysinhvien.dao.SinhVienDao;
import quanlysinhvien.entity.SinhVien;
import springmvccrud.entity.Emp;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDao dao;
	
	@RequestMapping("/addForm")
	public ModelAndView showForm() {
		return new ModelAndView("addForm","command",new SinhVien());
	}
	
	@RequestMapping("/viewAll")
	public ModelAndView viewAll() {
		List<SinhVien> listSV = dao.getDsSinhVien();
		return new ModelAndView("viewAll","list",listSV);
	}
	
	@RequestMapping("/updateSinhVien/{id}")
	public ModelAndView update(@PathVariable int id) {
		SinhVien sv = dao.getEmpById(id);
		return new ModelAndView("updateForm","command",sv);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sv") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/viewAll");
	}
}
