package hibernate.mvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hibernate.mvc.entity.Student;
import hibernate.mvc.service.StudentService;

@Controller
@RequestMapping("/")
public class AppController {
	private static final String UPLOAD_DIRECTORY = "E:\\upload";
	String search = "";
	@Autowired
	StudentService service;

	@Autowired
	MessageSource message;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "search" }, method = RequestMethod.POST)
	public String search(@PathParam(value = "search") String searchName) {
		search = searchName;
		return "redirect:/list/1";
	}

	@RequestMapping(value = { "list/{page}" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;

		List<Student> listAllStudents = service.findAllStudents();
		if (listAllStudents.size() < recordEnd) {
			recordEnd = listAllStudents.size();
		}
		List<Student> listStudents = service.getStudents(recordStart, recordEnd);

		int nOfPages = (int) Math.ceil((double) listAllStudents.size() / recordsPerPage);

		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listStudents", listStudents);

		

		return "listStudent";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;

		List<Student> listAllStudents = service.findAllStudents();
		if (listAllStudents.size() < recordEnd) {
			recordEnd = listAllStudents.size();
		}
		List<Student> listStudents = service.getStudents(recordStart, recordEnd);

		int nOfPages = (int) Math.ceil((double) listAllStudents.size() / recordsPerPage);

		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listStudents", listStudents);

		return "listStudent";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("edit", false);
		return "addStudent";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Student student, BindingResult result, ModelMap model,
			@RequestParam CommonsMultipartFile file) throws IOException {
		if (result.hasErrors()) {
			return "addStudent";
		}
		if (!service.isStudentIdUnique(student.getMaSV())) {
			FieldError idError = new FieldError("student", "maSV", message.getMessage("non.unique.id",
					new String[] { String.valueOf(student.getMaSV()) }, Locale.getDefault()));
			result.addError(idError);
			return "addStudent";
		}

		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			student.setAvatar(filename);
		} else {
			student.setAvatar("avatar.jpg");
		}

		service.saveStudent(student);

		return "redirect:/list";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{maSV}-student" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable int maSV, ModelMap model) {
		Student student = service.findById(maSV);
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return "addStudent";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{maSV}-student" }, method = RequestMethod.POST)
	public String editStudent(@Valid Student student, BindingResult result, ModelMap model, @PathVariable int maSV,
			@RequestParam CommonsMultipartFile file) throws IOException {
		if (result.hasErrors()) {
			return "addStudent";
		}
		if (!service.isStudentIdUnique(student.getMaSV())) {
			FieldError idError = new FieldError("student", "maSV", message.getMessage("non.unique.id",
					new String[] { String.valueOf(student.getMaSV()) }, Locale.getDefault()));
			result.addError(idError);
			return "addStudent";
		}
		String avatar = student.getAvatar();
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			student.setAvatar(filename);
		} else {
			student.setAvatar(avatar);
		}
		service.updateStudent(student);
		return "redirect:/list";
	}

	/*
	 * This method will delete an employee by it's id value.
	 */
	@RequestMapping(value = { "/delete-{maSV}-student" }, method = RequestMethod.POST)
	public String delete(@PathVariable int maSV) {
		service.deleteById(maSV);
		return "redirect:/list";
	}

	@RequestMapping(value = { "/delete-{maSV}-student" }, method = RequestMethod.GET)
	public String delete(@PathVariable int maSV, ModelMap model) {
		Student student = service.findById(maSV);
		model.addAttribute("student", student);
		model.addAttribute("delete", true);
		return "addStudent";
	}
}
