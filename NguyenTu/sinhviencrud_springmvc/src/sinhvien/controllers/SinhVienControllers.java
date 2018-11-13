package sinhvien.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sinhvien.beans.SinhVien;
import sinhvien.dao.SinhVienDao;

@Controller
public class SinhVienControllers {
	@Autowired
	SinhVienDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/svform")
	public ModelAndView showform() {
		return new ModelAndView("AddForm", "command", new SinhVien());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sv") SinhVien sv) {
		dao.save(sv);
		return new ModelAndView("redirect:/viewsv");// will redirect to viewsv request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewsv")
	public ModelAndView viewsv() {
		List<SinhVien> list = dao.getEmployees();
		return new ModelAndView("ViewForm", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editsv/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSinhVienById(id);
		return new ModelAndView("EditForm", "command", sv);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sv") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/viewsv");
	}

	/* It deletes record for the given id in URL and redirects to /viewsv */
	@RequestMapping(value = "/deletesv/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewsv");
	}
}
