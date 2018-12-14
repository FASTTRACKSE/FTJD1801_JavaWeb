package sinhvien.dao;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sinhvien.entity.Emp;
 
@Repository("empDao")
public class EmpDaoImpl extends AbstractDao<Integer, Emp> implements EmpDao {
 
    public Emp findById(int id) {
        return getByKey(id);
    }
 
    public void save(Emp employee) {
        persist(employee);
    }
 
    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from Emp99 where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Emp> getEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Emp>) criteria.list();
    }
    
    
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
 
    public List<Emp> findTeamByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (List<Emp>) criteria.list();
    }


	
}