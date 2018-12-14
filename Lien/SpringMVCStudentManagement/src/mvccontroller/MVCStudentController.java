package mvccontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import mvcdao.MVCStudentDao;
import mvcentity.Student;

@Controller
public class MVCStudentController {
	@Autowired
	MVCStudentDao mvcdao;// will inject dao from xml file
	String name = null;

	private static final String UPLOAD_DIRECTORY = "/imagestock";

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("add_student", "command", new Student());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") Student emp, @RequestParam CommonsMultipartFile file,
			HttpSession session) throws Exception {

		String filename = file.getOriginalFilename();

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("D:\\" + UPLOAD_DIRECTORY + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();

		emp.setAvatar(filename);
		mvcdao.save(emp);

		return new ModelAndView("redirect:/List");
	}

	@RequestMapping("/")
	public ModelAndView list() {
		return new ModelAndView("redirect:/List/1");
	}
	
	@RequestMapping(value = "/viewSearch", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchValue") String searchValue) {
		name = searchValue;
		return new ModelAndView("redirect:/");
	}

	/* It provides list of employees in model object */
	@RequestMapping("/List/{pageValue}")
	public ModelAndView List(@PathVariable int pageValue, Model model) {
		int perPage = 4;
		int nPage = 1;
		int currentPage = 0;
		double totalCount;
		if (name == null) {
			String hoten = "";
			List<Student> list = mvcdao.countStudent(hoten);
			totalCount = list.size();
		} else {
			List<Student> list = mvcdao.countStudent(name);
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
		List<Student> list = mvcdao.getSearchLimitStudent(currentPage, perPage, name);

		return new ModelAndView("List", "list", list);

	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Student sinhvien = mvcdao.getEmpById(id);
		return new ModelAndView("update_student", "command", sinhvien);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhvien") Student sinhvien) {
		mvcdao.update(sinhvien);
		return new ModelAndView("redirect:/List");
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		mvcdao.delete(id);
		return new ModelAndView("redirect:/List");
	}

}
