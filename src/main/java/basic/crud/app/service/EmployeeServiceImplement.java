package basic.crud.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import basic.crud.app.enitity.Address;
import basic.crud.app.enitity.Employee;
import basic.crud.app.enitity.Password;

@Singleton
public class EmployeeServiceImplement implements EmployeeService{

	@Inject
	Provider<EntityManager> employee;
	
	@Override
	@Transactional
	public void createNewEmployee(Employee emp,Address adr,Password pw) {
		long pin=adr.getPincode();
		
		EntityManager em=employee.get();
		
		Address address=null;
		
		Query query=em.createQuery("Select a from Address a where a.pincode="+pin);
		try {
		address=(Address)query.getSingleResult();
		}catch(Exception e)
		{
			
		}
		
		if(address!=null)
		{
			emp.setAdr(address);
		}
		else
		{
			em.persist(adr);
		}
		em.persist(pw);
		em.persist(emp);		
	}

	
	@Override
	@Transactional
	public List<Employee> showAllEmployee() {
		
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e,Address a where e.adr=a.pincode order by e.eid asc");
		List<Employee> empList=query.getResultList();
		return empList;		
	}

	
	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		EntityManager em=employee.get();
		
		Query query=em.createQuery("Delete from Employee e where e.eid="+id);
		query.executeUpdate();	
	}

	
	@Override
	@Transactional
	public void editEmployee(int id,Employee emp) {
		EntityManager em=employee.get();
		Query query=em.createQuery("Update Employee e set e.ename='"+emp.getEname()+"', e.salary="+emp.getSalary()+
					", e.position='"+emp.getPosition()+"', e.contact="+emp.getContact()+" where e.eid="+id);
		query.executeUpdate();
		
	}

	
	@Override
	@Transactional
	public List<Employee> searchByEmployeeId(int id) {
		
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e where e.eid="+id);
		List<Employee> emp=(List<Employee>) query.getResultList();
		return emp;
	}

	@Override
	@Transactional
	public List<Employee> searchByEmployeeName(String name) {
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e where e.ename='"+name+"'");
		List<Employee> empList= query.getResultList();
		return empList;
	}

	@Override
	@Transactional
	public List<Employee> searchByEmployeePosition(String position) {
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e where e.position='"+position+"'");
		List<Employee> empList= query.getResultList();
		return empList;
	}

	@Override
	@Transactional
	public List<Employee> sortByHighestSal() {
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e order by e.salary desc");
		List<Employee> empList=query.getResultList();
		return empList;	
	}

	@Override
	@Transactional
	public List<Employee> sortByLowestSal() {
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e order by e.salary asc");
		List<Employee> empList=query.getResultList();
		return empList;	
	}


	@Override
	@Transactional
	public boolean loginCheck(int id, String pass) {
		EntityManager em=employee.get();
		Password pw=null;
		Query query=em.createQuery("Select p from Password p where p.employ="+id+" and p.password='"+pass+"'");
		try {
			pw=(Password) query.getSingleResult();
		}catch(Exception e){
			
		}
		if(pw!=null) {
			return true;
		}
		return false;
	}

	

}
