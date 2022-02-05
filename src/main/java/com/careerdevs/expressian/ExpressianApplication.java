package com.careerdevs.expressian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpressianApplication {

	public static void main(String[] args) {

		DataBaseWriter.writeToDatabase();
		// SpringApplication.run(ExpressianApplication.class, args);
	}

}
