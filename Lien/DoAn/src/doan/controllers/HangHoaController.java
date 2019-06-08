package doan.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import doan.entity.HangHoa;
import doan.entity.NhomHang;
import doan.service.HangHoaService;
import doan.service.NhomHangService;

@Controller
@RequestMapping("/Admin/QuanLyDuLieu/HangHoa")
public class HangHoaController {
	private static final String UPLOAD_DIRECTORY = "E:\\upload";

	String tenHang = "";

	@Autowired
	HangHoaService hangHoaService;

	@Autowired
	NhomHangService nhomHangService;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listHangHoa(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<HangHoa> listAllHangHoa = hangHoaService.findAllHangHoa(tenHang);
		if (listAllHangHoa.size() < recordEnd) {
			recordEnd = listAllHangHoa.size();
		}
		List<HangHoa> HangHoa = hangHoaService.getHangHoa(currentPage, recordEnd, tenHang);

		int totalPage = (int) Math.ceil((double) listAllHangHoa.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("HangHoa", HangHoa);

		return "admin/QuanLyDuLieu/DSSanPham/HangHoa";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listHangHoaPaging(ModelMap model, @PathVariable int nPage) {

		int perPage = 4;
		List<HangHoa> listAllHangHoas = hangHoaService.findAllHangHoa();
		int totalPage = (int) Math.ceil((double) listAllHangHoas.size() / perPage);
		if (nPage < 1) {
			nPage = 1;
		}
		if (nPage > totalPage) {
			nPage = totalPage;
		}
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		if (listAllHangHoas.size() < recordEnd) {
			recordEnd = listAllHangHoas.size();
		}
		List<HangHoa> HangHoa = hangHoaService.getHangHoa(currentPage, recordEnd);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("HangHoa", HangHoa);

		return "admin/QuanLyDuLieu/DSSanPham/HangHoa";
	}

	@RequestMapping(value = { "duyet/{maHangHoa}" }, method = RequestMethod.GET)
	public String duyetDon(ModelMap model, @PathVariable int maHangHoa) {

//		HangHoa HangHoa= hangHoaService.findById(maHangHoa);
//		HangHoa.setTrangThai("Đã duyệt");
//		hangHoaService.updateHangHoa(HangHoa);

		return "redirect:/Admin/QuanLyHangHoa/DuyetDon";
	}

	@RequestMapping(value = { "huy/{maHangHoa}" }, method = RequestMethod.GET)
	public String huyDon(ModelMap model, @PathVariable int maHangHoa) {

//		HangHoa HangHoa= hangHoaService.findById(maHangHoa);
//		HangHoa.setTrangThai("Đã hủy");
//		hangHoaService.updateHangHoa(HangHoa);

		return "redirect:/Admin/QuanLyHangHoa/DuyetDon";
	}

	@RequestMapping(value = { "xem/{maHangHoa}" }, method = RequestMethod.GET)
	public String xemDon(ModelMap model, @PathVariable int maHangHoa) {

//		HangHoa HangHoa= hangHoaService.findById(maHangHoa);
//		HangHoa HangHoa = hangHoaService.findById(HangHoa.getMaHangHoa());
//		HangHoa HangHoa = hangHoaService.findById(HangHoa.getMaHangHoa());
//		
//		model.addAttribute("HangHoa", HangHoa);
//		model.addAttribute("HangHoa", HangHoa);
//		model.addAttribute("HangHoa", HangHoa);

		return "admin/QuanLyHangHoa/HangHoa";
	}

	@RequestMapping(value = { "/them" }, method = RequestMethod.GET)
	public String saveEmployee(ModelMap model) {
		HangHoa hangHoa = new HangHoa();
		List<NhomHang> nhomHang = nhomHangService.findAllNhomHang();
		model.addAttribute("hangHoa", hangHoa);
		model.addAttribute("nhomHang", nhomHang);
		model.addAttribute("edit", false);
		return "admin/QuanLyDuLieu/DSSanPham/ThemHangHoa";
	}

	@RequestMapping(value = { "/them" }, method = RequestMethod.POST)
	public String saveEmployee(@PathParam(value = "nhomHang") String nhomHang, @Valid HangHoa hangHoa,
			BindingResult result, ModelMap model, @RequestParam MultipartFile file) throws IOException {

		if (result.hasErrors()) {
			return "admin/QuanLyDuLieu/DSSanPham/ThemHangHoa";
		}
//		if (service.ishangHoaIdUnique(hangHoa.getIdEmployee())) {
//			FieldError idError = new FieldError("hangHoa", "idEmployee", message.getMessage("non.unique.id",
//					new String[] { String.valueOf(hangHoa.getIdEmployee()) }, Locale.getDefault()));
//			result.addError(idError);
//			return "QuanLyNhanSu/hosonhanvien/add_form";
//		}

		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			hangHoa.setFile(filename);
		} else {
			hangHoa.setFile("avatar.jpg");
		}
		int nhom = Integer.parseInt(nhomHang);
		hangHoa.setNhomHang(nhom);
		hangHoaService.saveHangHoa(hangHoa);

		return "redirect:/Admin/QuanLyDuLieu/HangHoa";
	}

}
