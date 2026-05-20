package com.example.skillexchange;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SkillExchangeApplicationTests {

	@Test
	void contextLoads() {
		// Verifies that the Spring Boot context boots up successfully
	}

	@Test
	void mainMethodRunsSuccessfully() {
		// Explicitly invokes the main method to guarantee 100% test coverage on the application class
		SkillExchangeApplication.main(new String[] {});
	}
}