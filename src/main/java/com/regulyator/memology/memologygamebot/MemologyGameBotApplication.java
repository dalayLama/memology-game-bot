package com.regulyator.memology.memologygamebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MemologyGameBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemologyGameBotApplication.class, args);
	}

}
