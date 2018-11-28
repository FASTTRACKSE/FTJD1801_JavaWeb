package hibernate.student.controller;

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

import hibernate.student.entity.Student;
import hibernate.student.service.StudentService;


@Controller
@RequestMapping("/")
public class StudentController {
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
	public String search(@PathParam(value = "searchName") String searchName) {
		search = searchName;
		return "redirect:/list/1";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<Student> listAllStudents = service.findAllStudents(search);
		if (listAllStudents.size() < recordEnd) {
			recordEnd = listAllStudents.size();
		}
		List<Student> students = service.getStudents(currentPage, recordEnd,search);

		int totalPage = (int) Math.ceil((double) listAllStudents.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("students", students);

		return "list";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<Student> listAllStudents = service.findAllStudents();
		if (listAllStudents.size() < recordEnd) {
			recordEnd = listAllStudents.size();
		}
		List<Student> students = service.getStudents(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllStudents.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("students", students);

		return "list";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("edit", false);
		return "add";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Student student, BindingResult result, ModelMap model,
			@RequestParam CommonsMultipartFile file) throws IOException {
		if (result.hasErrors()) {
			return "add";
		}
		if (service.isStudentIdUnique(student.getMaSV())) {
			FieldError idError = new FieldError("student", "maSV", message.getMessage("non.unique.id",
					new String[] { String.valueOf(student.getMaSV()) }, Locale.getDefault()));
			result.addError(idError);
			return "add";
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
	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, ModelMap model) {
		Student student = service.findById(id);
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return "add";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.POST)
	public String editStudent(@Valid Student student, BindingResult result, ModelMap model, @PathVariable int id,
			@RequestParam CommonsMultipartFile file) throws IOException {
		if (result.hasErrors()) {
			return "add";
		}
		if (!service.isStudentIdUnique(student.getMaSV())) {
			FieldError idError = new FieldError("student", "id", message.getMessage("non.unique.id",
					new String[] { String.valueOf(student.getMaSV()) }, Locale.getDefault()));
			result.addError(idError);
			return "add";
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
			//student.setAvatar(avatar);
		}
		service.updateStudent(student);
		return "redirect:/list";
	}

	/*
	 * This method will delete an employee by it's id value.
	 */
	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.POST)
	public String delete(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/list";
	}
	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, ModelMap model) {
		Student student = service.findById(id);
		model.addAttribute("student", student);
		model.addAttribute("delete", true);
		return "add";
	}
}
