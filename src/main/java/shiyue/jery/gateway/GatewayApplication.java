package shiyue.jery.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GatewayApplication {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("1111111");
		System.out.println(environment.getProperty("spring.application.name"));
	}

}
