package quanlysinhvien.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

import quanlysinhvien.dao.SinhVienDao;
import quanlysinhvien.entity.SinhVien;

@Controller
public class SinhVienController {
	private static final String UPLOAD_DIRECTORY = "E:\\upload";

	@Autowired
	SinhVienDao dao;

	@RequestMapping("/addForm")
	public ModelAndView showForm() {
		return new ModelAndView("addForm", "command", new SinhVien());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") SinhVien sv, @RequestParam CommonsMultipartFile file,
			HttpSession session) throws IOException {
		if (!(sv.getHoTen().equals("") || sv.getNamSinh() == 0 || sv.getGioiTinh().equals("")
				|| sv.getEmail().equals("") || sv.getDiaChi().equals("") || sv.getLopHoc().equals("")
				)) {
		if (file != null) {
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			sv.setAnhThe(filename);
		}
			dao.save(sv);
		}
		return new ModelAndView("redirect:/viewAll/1");// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewAll/{pageId}")
	public ModelAndView viewAll(@PathVariable int pageId,Model model) {
		int recordsPerPage = 3;
		int recordStart = 1;
		if (pageId == 1) {
		} else {
			recordStart = (pageId - 1) * recordsPerPage + 1;
		}
		List<SinhVien> list = dao.getNumberOfRows();
		int nOfPages = (int) Math.ceil(list.size() / recordsPerPage);
		List<SinhVien> listSV = dao.getDsSinhVien(recordStart, recordsPerPage);
		model.addAttribute("noOfPages",nOfPages);
		model.addAttribute("pageid",pageId);
		return new ModelAndView("viewAll", "list", listSV);
	}

	@RequestMapping("/updateForm/{id}")
	public ModelAndView update(@PathVariable int id) {
		SinhVien sv = dao.getEmpById(id);
		return new ModelAndView("updateForm", "command", sv);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateSave(@ModelAttribute("sv") SinhVien sv, @RequestParam CommonsMultipartFile file,
			HttpSession session) throws Exception {
		if (file != null) {
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			sv.setAnhThe(filename);
		}
		dao.update(sv);
		return new ModelAndView("redirect:/viewAll/1");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewAll/1");
	}
}
