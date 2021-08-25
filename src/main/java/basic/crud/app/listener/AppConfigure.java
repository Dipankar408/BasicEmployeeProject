package basic.crud.app.listener;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

import basic.crud.app.module.AppModule;

public class AppConfigure extends GuiceResteasyBootstrapServletContextListener{
	
	@Override
	public List<? extends Module> getModules(ServletContext context){
		
		return Arrays.asList(new JpaPersistModule("employeebook"),new AppModule());
	}
	
	@Override
	public void withInjector(Injector injector) {
		injector.getInstance(PersistService.class).start();
	}

}
