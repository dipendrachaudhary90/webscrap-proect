package com.springbootwebscrap;

import com.springbootwebscrap.service.DocumentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
@SpringBootApplication
public class SpringbootWebscrapApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(SpringbootWebscrapApplication.class, args);
		System.out.println(DocumentService.fetch());

	}
}
