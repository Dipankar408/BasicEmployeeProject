package basic.crud.app.service;

import java.util.List;

import basic.crud.app.enitity.Address;
import basic.crud.app.enitity.Employee;
import basic.crud.app.enitity.Password;

public interface EmployeeService {

	public void createNewEmployee(Employee emp,Address adr,Password pw);
	
	public List<Employee> showAllEmployee();
	
	public void deleteEmployee(int id);
	
	public void editEmployee(int id,Employee emp);
	
	public List<Employee> searchByEmployeeId(int id);
	
	public List<Employee> searchByEmployeeName(String name);
	
	public List<Employee> searchByEmployeePosition(String position);
	
	public List<Employee> sortByHighestSal();
	
	public List<Employee> sortByLowestSal();
	
	public boolean loginCheck(int id,String pass);
}
