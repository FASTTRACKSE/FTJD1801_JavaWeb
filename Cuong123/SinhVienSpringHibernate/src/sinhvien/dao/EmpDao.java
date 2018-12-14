package sinhvien.dao;
 
import java.util.List;

import sinhvien.entity.Emp;
 
public interface EmpDao {
 
    Emp findById(int id);
 
    void save(Emp emp);
     
    void delete(int id);
     
    List<Emp> getEmployees();
 
   
    
    List<Emp> findTeamByName(String search);
 
}