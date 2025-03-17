package com.player.rank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlayerRankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerRankServiceApplication.class, args);
	}

}
