package basic.crud.app.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

import basic.crud.app.enitity.Address;
import basic.crud.app.enitity.Employee;
import basic.crud.app.enitity.Password;
import basic.crud.app.service.EmployeeService;

@Singleton
@Path("/")
public class EmployeeResource {
	
	@Inject
	EmployeeService empService;
	
	@GET
	public View indexView(){
		String msg="";
		return new View("/index.jsp",msg,"msg");
	}
	{
		
	}
	
	@GET
	@Path("employeeList")
	public View displayAllEmployee() {
		
		List<Employee> empList=empService.showAllEmployee();
		return new View("/employeeList.jsp",empList,"empList");
	}
	
	@POST
	@Path("createEmp")
	public View createEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException{
		String name=req.getParameter("ename");
		String pos=req.getParameter("position");
		
		Employee emp=new Employee();
		Address adr=new Address();
		
		
		try {
			double sal=Double.parseDouble(req.getParameter("salary"));
			long num=Long.parseLong(req.getParameter("contact"));
			long pin=Long.parseLong(req.getParameter("pin"));
			
			emp.setSalary(sal);
			emp.setContact(num);
			adr.setPincode(pin);
		}catch(NumberFormatException e)
		{
			String msg="Salary,Contact Number and Pincode should be in number";
			return new View("/index.jsp",msg,"msg");
		}
		String city=req.getParameter("city");
		String dist=req.getParameter("district");
		String state=req.getParameter("state");
		String pass=req.getParameter("pass");
		
		
		emp.setEname(name);
		emp.setPosition(pos);
		
		adr.setCity(city);
		adr.setDistrict(dist);
		adr.setState(state);
		
		emp.setAdr(adr);
		
		Password pw=new Password();
		pw.setPassword(pass);
		pw.setEmploy(emp);
		
		empService.createNewEmployee(emp,adr,pw);
		return displayAllEmployee();
	}
	
	
	@GET
	@Path("edit/{id}")
	public void editEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp,@PathParam("id") int id) throws ServletException, IOException {
		List<Employee> empList=(List<Employee>) empService.searchByEmployeeId(id);
		req.setAttribute("empList", empList);
		req.setAttribute("msg", "");
		RequestDispatcher rd=req.getRequestDispatcher("/update.jsp");
		rd.forward(req, resp);
	}
	
	
	@POST
	@Path("update/{id}")
	public void udateEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp, @PathParam("id") int id) throws IOException, ServletException{
		String name=req.getParameter("ename");
		String pos=req.getParameter("position");
		
		Employee emp=new Employee();
		emp.setEname(name);
		emp.setPosition(pos);
		try {
			double sal=Double.parseDouble(req.getParameter("salary"));
			long num=Long.parseLong(req.getParameter("contact"));
			
			emp.setSalary(sal);
			emp.setContact(num);
			
			empService.editEmployee(id, emp);
			List<Employee> empList=empService.showAllEmployee();
			req.setAttribute("empList", empList);
			req.setAttribute("msg", "");
			RequestDispatcher rd=req.getRequestDispatcher("/employeeList.jsp");
			rd.forward(req, resp);
		}
		catch(NumberFormatException e) {
			List<Employee> empList=(List<Employee>) empService.searchByEmployeeId(id);
			req.setAttribute("empList", empList);
			req.setAttribute("msg", "Salary and Number should be in number");
			RequestDispatcher rd=req.getRequestDispatcher("/update.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	
	
	@GET
	@Path("delete/{id}")
	public View deleteEmployee(@PathParam("id") int id) {
		empService.deleteEmployee(id);
		return displayAllEmployee();
	}
	
	
	@POST
	@Path("search")
	public void searchEmployee(@Context HttpServletRequest req, @Context HttpServletResponse resp)throws IOException, ServletException {
		String val=req.getParameter("val");
		String search_cat=req.getParameter("search_category");
		List<Employee> empList=null;
		String message="";
		if(search_cat.equalsIgnoreCase("searchById"))
		{
			int id=0;
			try {
				id=Integer.parseInt(val);
				empList=empService.searchByEmployeeId(id);
			}catch(NumberFormatException e) {
				message="Id should be in number";
				req.setAttribute("empList", empList);
				req.setAttribute("message", message);
				RequestDispatcher rd=req.getRequestDispatcher("/employeeList.jsp");
				rd.forward(req, resp);
			}
		}
		else if(search_cat.equalsIgnoreCase("searchByName"))
		{
			empList=empService.searchByEmployeeName(val);
		}
		else if(search_cat.equalsIgnoreCase("searchByPosition"))
		{
			empList=empService.searchByEmployeePosition(val);
		}
		
		if(empList.isEmpty())
		{
			message="Not found any match data";
		}
//		return new View("/employeeList.jsp",empList,"empList");
		req.setAttribute("empList", empList);
		req.setAttribute("message", message);
		RequestDispatcher rd=req.getRequestDispatcher("/employeeList.jsp");
		rd.forward(req, resp);
	}
	
	
	@GET
	@Path("sortFromHigh")
	public View highToLow() {
		List<Employee> empList=empService.sortByHighestSal();
		return new View("/employeeList.jsp",empList,"empList");
	}
	
	
	@GET
	@Path("sortFromLow")
	public View lowToHigh() {
		List<Employee> empList=empService.sortByLowestSal();
		return new View("/employeeList.jsp",empList,"empList");
	}
	
	@GET
	@Path("login/{id}/{task}")
	public void loginPage(@PathParam("id") int id, @PathParam("task") String task, @Context HttpServletRequest req, @Context HttpServletResponse resp)throws IOException, ServletException {
		req.setAttribute("task", task);
		req.setAttribute("id", id);
		req.setAttribute("msg", "");
		RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
	}
	
	@POST
	@Path("authentication/{task}/{id}")
	public void authentication(@PathParam("id") int id,@PathParam("task") String task,@Context HttpServletRequest req, @Context HttpServletResponse resp)throws IOException, ServletException  {
		String pass=req.getParameter("pass");
		if(empService.loginCheck(id, pass))
		{
			if(task.equalsIgnoreCase("delete"))
			{
				resp.sendRedirect("http://localhost:8080/EmployeeBook/delete/"+id);
			}
			else {
				resp.sendRedirect("http://localhost:8080/EmployeeBook/edit/"+id);
			}
		}
		else {
//			resp.sendRedirect("http://localhost:8080/EmployeeBook/login/"+id+"/"+task);
			req.setAttribute("task", task);
			req.setAttribute("id", id);
			req.setAttribute("msg", "Invalid Password");
			RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
	}
	
	
}
