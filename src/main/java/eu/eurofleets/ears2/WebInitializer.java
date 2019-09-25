package eu.eurofleets.ears2;

import org.springframework.boot.builder.SpringApplicationBuilder;
// old import org.springframework.boot.context.web.SpringBootServletInitializer;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
public class WebInitializer
  extends SpringBootServletInitializer
{
	
	
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { return application.sources(new Class[] { Application.class }); }
}
