package springmvc.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.student.dao.StudentDAO;
import springmvc.student.entity.Student;

@Controller  
public class StudentController {
	@Autowired
	StudentDAO dao;
	String name = null;

	@RequestMapping("/add")
	public ModelAndView showform() {
		return new ModelAndView("add", "command", new Student());
	}

	@RequestMapping(value = "/runAdd", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("student") Student student) {
		dao.addStudent(student);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/")
	public ModelAndView list() {
		List<Student> list = dao.getAllStudent();
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
		if(name == null) {
			String hoten = "";
			List<Student> list = dao.countStudent(hoten);
			totalCount = list.size();
		}else {
			List<Student> list = dao.countStudent(name);
			totalCount = list.size();
		}
		int totalPage = (int) Math.ceil(totalCount/perPage);
		
		nPage = pageValue;
		if(nPage > totalPage) {
			nPage = totalPage;
		}
		if(nPage < 1) {
			nPage = 1;
		}
		currentPage = (nPage - 1)*perPage;
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		
		if(name == null) {
			name = "";
		}
		model.addAttribute("nameValue", name);
		
		List<Student> list = dao.getSearchLimitStudent(currentPage, perPage, name);
		return new ModelAndView("list", "list", list);
	}
	
	@RequestMapping(value = "/editstudent/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Student student = dao.getStudentById(id);
		return new ModelAndView("update", "command", student);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student student) {
		dao.updateStudent(student);
		return new ModelAndView("redirect:/viewstudent");
	}
	
	@RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.deleteStudent(id);
		return new ModelAndView("redirect:/viewstudent");
	}
}
