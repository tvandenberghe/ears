package eu.eurofleets.ears2;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
@PropertySources({
	
	@PropertySource(name = "application.properties",value = "application.properties", factory = OSAgnosticPropertySourceFactory.class)
	//,
	//@PropertySource(name = "hibernate.properties",value = "hibernate.properties", factory = OSAgnosticPropertySourceFactory.class)
	//@PropertySource("file:${catalina.base}/ears/application.properties"),
	//@PropertySource("file:${catalina.base}/ears/hibernate.properties")
	 //  @PropertySource("path:	java.nio.file.Paths.get(System.getProperty("catalina.base"), "var", "www", "ears2")application.properties" ),
 //   @PropertySource("classpath:application.properties" ),
   // @PropertySource("classpath:hibernate.properties" )

})
//new File(System.getProperty("catalina.base"), "ears")
@Configuration
@ComponentScan
@EnableJpaRepositories
@Import({org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration.class})
@EnableAutoConfiguration
public class Application
{
	

  public static void main(String[] args) { 
	  
	//  SpringApplication.run(Application.class, args); 
	  
	  ConfigurableApplicationContext ctx =
              SpringApplication.run(Application.class, args);

      ConfigurableEnvironment env = ctx.getEnvironment();
      
      env.getPropertySources()
              .forEach(ps -> System.out.println("---------------------------------------------"+ps.getName() + " : " + ps.getClass()));

    //  System.out.println("Value of  = " + env.getProperty("driverClassName"));
  }
}





