package basic.crud.app.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.plugins.providers.html.View;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import basic.crud.app.enitity.Employee;
import basic.crud.app.service.EmployeeService;

@Singleton
@Path("/")
public class EmployeeResource {
	
	@Inject
	EmployeeService empService;
	
	@GET
	public View displayAllEmployee() {
		
		List<Employee> empList=empService.showAllEmployee();
		return new View("/index.jsp",empList,"empList");
	}
	
	@POST
	@Path("createEmp")
	public void createEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException{
		String name=req.getParameter("ename");
		double sal=Double.parseDouble(req.getParameter("salary"));
		String pos=req.getParameter("position");
		long num=Long.parseLong(req.getParameter("contact"));
		
		Employee emp=new Employee();
		emp.setEname(name);
		emp.setSalary(sal);
		emp.setPosition(pos);
		emp.setContact(num);
		
		empService.createNewEmployee(emp);
	}
	

}
