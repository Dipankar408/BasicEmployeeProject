package basic.crud.app.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public View createEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException{
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
		return displayAllEmployee();
	}
	
	
	@GET
	@Path("edit/{id}")
	public View editEmployee(@PathParam("id") int id) {
		List<Employee> empList=(List<Employee>) empService.searchByEmployeeId(id);
		return new View("/update.jsp",empList,"empList");
	}
	
	
	@POST
	@Path("update/{id}")
	public View udateEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp, @PathParam("id") int id) throws IOException{
		String name=req.getParameter("ename");
		double sal=Double.parseDouble(req.getParameter("salary"));
		String pos=req.getParameter("position");
		long num=Long.parseLong(req.getParameter("contact"));
		
		Employee emp=new Employee();
		emp.setEname(name);
		emp.setSalary(sal);
		emp.setPosition(pos);
		emp.setContact(num);
		
		empService.editEmployee(id, emp);;
		return displayAllEmployee();
	}
	
	
	
	@GET
	@Path("delete/{id}")
	public View deleteEmployee(@PathParam("id") int id) {
		empService.deleteEmployee(id);
		return displayAllEmployee();
	}
	
	
	@POST
	@Path("search")
	public View searchEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp)throws IOException {
		String val=req.getParameter("val");
		String search_cat=req.getParameter("search_category");
		List<Employee> empList=null;
		if(search_cat.equalsIgnoreCase("searchById"))
		{
			int id=Integer.parseInt(val);
			empList=empService.searchByEmployeeId(id);
		}
		else if(search_cat.equalsIgnoreCase("searchByName"))
		{
			empList=empService.searchByEmployeeName(val);
		}
		else if(search_cat.equalsIgnoreCase("searchByPosition"))
		{
			empList=empService.searchByEmployeePosition(val);
		}
		return new View("/index.jsp",empList,"empList");
	}
	
	
	@GET
	@Path("sortFromHigh")
	public View highToLow() {
		List<Employee> empList=empService.sortByHighestSal();
		return new View("/index.jsp",empList,"empList");
	}
	
	
	@GET
	@Path("sortFromLow")
	public View lowToHigh() {
		List<Employee> empList=empService.sortByLowestSal();
		return new View("/index.jsp",empList,"empList");
	}
	
	
}
