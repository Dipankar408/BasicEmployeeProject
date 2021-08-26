package basic.crud.app.service;

import java.util.List;

import basic.crud.app.enitity.Address;
import basic.crud.app.enitity.Employee;

public interface EmployeeService {

	public void createNewEmployee(Employee emp,Address adr);
	
	public List<Employee> showAllEmployee();
	
	public void deleteEmployee(int id);
	
	public void editEmployee(int id,Employee emp);
	
	public List<Employee> searchByEmployeeId(int id);
	
	public List<Employee> searchByEmployeeName(String name);
	
	public List<Employee> searchByEmployeePosition(String position);
	
	public List<Employee> sortByHighestSal();
	
	public List<Employee> sortByLowestSal();
}
