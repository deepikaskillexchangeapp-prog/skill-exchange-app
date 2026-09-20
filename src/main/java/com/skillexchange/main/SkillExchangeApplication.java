package com.skillexchange.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SkillExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillExchangeApplication.class, args);
	}

}
