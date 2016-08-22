package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.EnvironmentAccessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DeathableSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeathableSpringBootApplication.class, args);
	}

}

@RestController
class DefaultController{

	@Autowired
	Environment env;

	@Autowired
	ApplicationContext appContext;

	@GetMapping({"/", "/index"})
	public String index(){
		return "hello world,  my name : "+env.getProperty("name");
	}

	@GetMapping("/die")
	public void die(){
		SpringApplication.exit(appContext, ()->0);
	}
}
