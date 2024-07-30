package com.vishal.eurekha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekhaApplication.class, args);
	}

}
