package sinhvien.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sinhvien.beans.SinhVien;
import sinhvien.dao.SinhVienDao;

@Controller
public class SinhVienControllers {
	@Autowired
	SinhVienDao dao;
	String name = null;
	private static final String UPLOAD_DIRECTORY = "E:\\upload";

	@RequestMapping("/add")
	public ModelAndView showform() {
		return new ModelAndView("AddForm", "command", new SinhVien());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sv") SinhVien sv, @RequestParam CommonsMultipartFile file) throws IOException {

		if (!(sv.getTenSv().equals("") || sv.getNamSinh() == 0)) {
			if (file != null) {
				String filename = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
				stream.write(bytes);
				stream.flush();
				stream.close();
				sv.setImage(filename);
			}
			dao.add(sv);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/")
	public ModelAndView list() {
		return new ModelAndView("redirect:/paging/1");
	}

	@RequestMapping(value = "/viewSearch", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchValue") String searchValue) {
		name = searchValue;
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/paging/{pageValue}")
	public ModelAndView paging(@PathVariable int pageValue, Model model) {
		int perPage = 4;
		int nPage = 1;
		int currentPage = 0;
		double totalCount;
		if (name == null) {
			String hoten = "";
			List<SinhVien> list = dao.countSinhVien(hoten);
			totalCount = list.size();
		} else {
			List<SinhVien> list = dao.countSinhVien(name);
			totalCount = list.size();
		}
		int totalPage = (int) Math.ceil(totalCount / perPage);

		nPage = pageValue;
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		if (nPage < 1) {
			nPage = 1;
		}
		currentPage = (nPage - 1) * perPage;

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);

		if (name == null) {
			name = "";
		}
		model.addAttribute("nameValue", name);

		List<SinhVien> list = dao.getSearchLimitSinhVien(currentPage, perPage, name);
		return new ModelAndView("ListForm", "list", list);
	}

//	@RequestMapping("/viewsv")
//	public ModelAndView viewsv() {
//		List<SinhVien> list = dao.getEmployees();
//		return new ModelAndView("ViewForm", "list", list);
//	}
	@RequestMapping(value = "/formedit/{id}")
	public ModelAndView editsave(@PathVariable int id) {
		SinhVien sinhvien = dao.getSinhVienById(id);
		return new ModelAndView("EditForm", "command", sinhvien);
	}
	@RequestMapping(value = "/editsv",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sv") SinhVien sv, @RequestParam CommonsMultipartFile file,
			HttpSession session) throws IOException {
		if (!(sv.getTenSv().equals("") || sv.getNamSinh() == 0)) {
			if (!file.isEmpty()) {
				String filename = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
				stream.write(bytes);
				stream.flush();
				stream.close();
				sv.setImage(filename);
			}
			dao.update(sv);
		}
		return new ModelAndView("redirect:/");
	}

	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/");
	}
}
