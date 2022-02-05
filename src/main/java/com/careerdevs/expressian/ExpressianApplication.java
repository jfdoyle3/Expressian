package com.careerdevs.expressian;


import com.careerdevs.expressian.entities.auth.ERole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpressianApplication {
//	@Value("${spring.datasource.url}")
//	private static String dbUrl;
//
//	@Value("${spring.datasource.username")
//	private static String dbUsername;
//
//	@Value("${spring.datasource.password")
//	private static String dbPassword;

	public static void main(String[] args) {

//		System.out.printf("%s\n%s\n%s",dbUrl,dbUsername,dbPassword);


		SpringApplication.run(ExpressianApplication.class, args);

	}

}
