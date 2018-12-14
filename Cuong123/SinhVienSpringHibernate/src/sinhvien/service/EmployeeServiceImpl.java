package sinhvien.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sinhvien.dao.EmpDao;
import sinhvien.entity.Emp;


 
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmpDao dao;
     
    public Emp findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Emp employee) {
        dao.save(employee);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void update(Emp employee) {
        Emp entity = findById(employee.getId());
        if(entity!=null){
            entity.setName(employee.getName());
            entity.setTuoi(employee.getTuoi());
            entity.setEmail(employee.getEmail());
            entity.setGioiTinh(employee.getGioiTinh());
            entity.setDiaChi(employee.getDiaChi());
            entity.setLopHoc(employee.getLopHoc());
            entity.setAnhThe(employee.getAnhThe());
            
            
        }
    }
 
    public void delete(int id) {
        dao.delete(id);
    }
     
    public List<Emp> getEmployees() {
        return dao.getEmployees();
    }
 
    public List<Emp> findTeamByName(String search) {
        return dao.findTeamByName(search);
    }
 
   
     
}