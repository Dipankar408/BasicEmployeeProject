package basic.crud.app.module;

import com.google.inject.AbstractModule;

import basic.crud.app.resource.EmployeeResource;
import basic.crud.app.service.EmployeeService;
import basic.crud.app.service.EmployeeServiceImplement;

public class AppModule extends AbstractModule{

	@Override
	public void configure() {
		
		bind(EmployeeResource.class);
		bind(EmployeeService.class).to(EmployeeServiceImplement.class);
	}
}
