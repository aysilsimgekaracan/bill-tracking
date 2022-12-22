package com.example.billtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BilltrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BilltrackingApplication.class, args);

	}


}
