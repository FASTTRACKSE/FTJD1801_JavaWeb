package doan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doan.entity.HangHoa;
import doan.service.HangHoaService;

@Controller
@RequestMapping("/Client/TrangRau")
public class TrangRauController {

	@SuppressWarnings("unused")
	private static final String UPLOAD_DIRECTORY = "E:\\upload";

	@Autowired
	HangHoaService hangHoaService;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "", "/", "list" }, method = RequestMethod.GET)
	public String listHangHoa(ModelMap model) {
		int nPage = 1;
		int perPage = 12;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<HangHoa> listAllHangHoa = hangHoaService.findAllHangHoa();
		if (listAllHangHoa.size() < recordEnd) {
			recordEnd = listAllHangHoa.size();
		}
		List<HangHoa> HangHoa = hangHoaService.getHangHoa(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllHangHoa.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("HangHoa", HangHoa);

		return "client/TrangRau";
	}

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listHangHoaPaging(ModelMap model, @PathVariable int nPage) {

		int perPage = 12;
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

		return "client/TrangRau";
	}

}