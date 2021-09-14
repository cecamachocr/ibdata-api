package mx.unam.ib.ibdata.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@ComponentScan(basePackages = "mx.unam.ib.ibdata.api")
@EnableEncryptableProperties
public class IbdApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(IbdApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IbdApplication.class);
    }

}
