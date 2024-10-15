package com.example.client;

import com.example.client.service.AddressClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ClientApplication.class, args);
//		AddressClientService greeterClientService = applicationContext.getBean(AddressClientService.class);
//		greeterClientService.getAddress("13960000");
	}

}
