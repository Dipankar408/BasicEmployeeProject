package basic.crud.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import basic.crud.app.enitity.Employee;

@Singleton
public class EmployeeServiceImplement implements EmployeeService{

	@Inject
	Provider<EntityManager> employee;
	
	@Override
	@Transactional
	public void createNewEmployee(Employee emp) {
		
		EntityManager em=employee.get();
		em.persist(emp);		
	}

	
	@Override
	@Transactional
	public List<Employee> showAllEmployee() {
		
		EntityManager em=employee.get();
		Query query=em.createQuery("Select e from Employee e order by e.eid asc");
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

	

}
