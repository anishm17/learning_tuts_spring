package com.team.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class TeamDataServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
//		HttpComponentsClientHttpRequestFactory  hccRP  =  new HttpComponentsClientHttpRequestFactory();
//		hccRP.setConnectTimeout(5000);
//		return new RestTemplate(hccRP);
		
	    return new RestTemplate();
	}
	
	@Bean
	public WebClient.Builder  getWebClientBuilder(){
		return   WebClient.builder();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(TeamDataServiceApplication.class, args);
	}

}
