package eu.eurofleets.ears2;

import java.io.File;

import java.io.IOException;

import java.nio.file.Path;


import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

public class OSAgnosticPropertySourceFactory  implements PropertySourceFactory {


	
	@Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		
		File configDir = new File(System.getProperty("catalina.base"), "ears");
	    Path resolvedFilePath = configDir.toPath().resolve(name);
        EncodedResource er = new EncodedResource(new FileSystemResource(resolvedFilePath), resource.getCharset());
        return (name != null ? new ResourcePropertySource(name, er) : new ResourcePropertySource(er));
    }


}
