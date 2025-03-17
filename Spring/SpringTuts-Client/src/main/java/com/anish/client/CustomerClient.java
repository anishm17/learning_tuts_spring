package com.anish.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.anish.model.CustomerDto;

@ConfigurationProperties(prefix = "anish.customer" ,ignoreUnknownFields = false)
@Component
public class CustomerClient {

	public final  String  PATH ="api/anish/customer/";

	private String apiPort;

	RestTemplate  restTemplate ;
	
	

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	public void setApiPort(String apiPort) {
		this.apiPort = apiPort;
	}
	public CustomerDto getCustomerById (UUID customerID) {
		return restTemplate.getForObject(apiPort +  PATH + customerID.toString() ,CustomerDto.class);
	}
	public URI saveCustomerDto (CustomerDto dto) {
		return restTemplate.postForLocation(apiPort +  PATH , dto);
	}
	
	public void  performUpdate(UUID customerID  ,  CustomerDto dto) {
		restTemplate.put(apiPort + PATH + "/" +customerID, dto);
	}
	
	public  void  delete(UUID customerID) {
		restTemplate.delete(apiPort + PATH   +  customerID);
		
	}


}
