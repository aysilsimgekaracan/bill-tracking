package com.example.billtracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@RestController
public class BilltrackingApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

/*
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
*/

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO User (name, surname, username, email, password) VALUES (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, "aysil", "karacan", "username3", "email@email.com", "12345");

		if (result > 0) {
			System.out.println("A new row has been inserted.");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(BilltrackingApplication.class, args);

	}


}
