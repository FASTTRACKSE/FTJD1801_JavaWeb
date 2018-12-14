package sinhvien.service;
 
import java.util.List;
 


import sinhvien.entity.Emp;
 
public interface EmployeeService {
 
	 Emp findById(int id);
	 
	    void save(Emp emp);
	     
	    void delete(int id);
	     
	    List<Emp> getEmployees();
	 
	    void update(Emp emp);
	    
	    List<Emp> findTeamByName(String search);
     
}