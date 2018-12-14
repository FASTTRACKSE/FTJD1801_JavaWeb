package controller;
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

import dao.EmpDao;
import entity.Emp;  
@Controller  
public class EmpController {  
    @Autowired  
    EmpDao dao;//will inject dao from xml file  
    String search = "";
    private static final String UPLOAD_DIRECTORY ="/imagestock";    
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/empform")  
    public ModelAndView showform(){  
        return new ModelAndView("empform","command",new Emp());  
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  

    @RequestMapping(value="save",method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Emp emp, @RequestParam CommonsMultipartFile file,  
           HttpSession session) throws Exception{  
    	 
        String filename = file.getOriginalFilename();  
   
        byte[] bytes = file.getBytes();  
        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
             new File("D:\\" + UPLOAD_DIRECTORY + File.separator + filename)));  
        stream.write(bytes);  
        stream.flush();  
        stream.close();  
        
        emp.setAnhThe(filename);           
        dao.save(emp);
         
        return new ModelAndView("redirect:/viewemp");  
    }  
    
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        List<Emp> list=dao.getEmployees();
        
        return new ModelAndView("viewemp","list",list);  
    }  
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Emp emp=dao.getEmpById(id);  
        return new ModelAndView("empeditform","command",emp);  
    } 
    
    /* It updates model object. */ 
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") Emp emp, @RequestParam CommonsMultipartFile file,  
            HttpSession session) throws Exception{ 
    	
    	
    	String filename = file.getOriginalFilename();  
    	
    	if(filename != "") { 
        byte[] bytes = file.getBytes();  
        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
             new File("D:\\" + UPLOAD_DIRECTORY + File.separator + filename)));  
        stream.write(bytes);  
        stream.flush();  
        stream.close();  
        
        	 emp.setAnhThe(filename);
        }
                
        dao.update(emp);  
        return new ModelAndView("redirect:/viewemp");  
    }  
    
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/viewemp");  
    }  
    
    @RequestMapping(value="/viewemp/{pageid}")  
    public ModelAndView edit2(@PathVariable int pageid,Model model){  
    	
    	int recordsPerPage = 3;
		int recordStart = (pageid - 1) * recordsPerPage;

		List<Emp> list = dao.findTeamByName(search);
		int totalPage = (int) Math.ceil((double) list.size() / recordsPerPage);
		List<Emp> listSV = dao.getEmployeesByPage(search, recordStart, recordsPerPage);
		
		int currentPage = 1;
		

		if(totalPage == 0) {
			currentPage = 1;
		}else if(pageid < 1) {
			currentPage = 1;
		}else if(pageid > totalPage) {
			currentPage = totalPage;	
		}else {
			currentPage = pageid;
		}
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		return new ModelAndView("viewemp", "list", listSV);
	
    /*	int perPage = 3;  
    	
		int totalSinhVien = dao.countSinhVien();
		int totalPage = (int) Math.ceil((float) (totalSinhVien) / perPage);
		int currentPage = 1;
		

			if(totalPage == 0) {
				currentPage = 1;
			}else if(pageid < 1) {
				currentPage = 1;
			}else if(pageid > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = pageid;
			}
		
        List<Emp> list=dao.getEmployeesByPage(currentPage,perPage);  
       
            ModelAndView mav = new ModelAndView("viewemp");

            mav.addObject("list", list);
            mav.addObject("currentPage", currentPage);
            mav.addObject("totalPage", totalPage);

            return mav;*/
        }  
       
    
    @RequestMapping(value="/search",method = RequestMethod.POST)  
    public ModelAndView Search(@RequestParam String searchTerm) {
    	
    	search = searchTerm;
       
    	return new ModelAndView("redirect:/viewemp/1");

        
         
    }  
  
  
}  
