package com.anish;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anish.client.CustomerClient;
import com.anish.model.CustomerDto;

@SpringBootTest
class CustomerTest {
	
	@Autowired
	private CustomerClient  customerClient;

	@Test
	void getCustomerById() {
		CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
		assertNotNull(customerDto);
	}
	
	@Test
	void saveCustomerData() {
		CustomerDto customerDto  =  CustomerDto.builder().name("AASIS MOHAN").build();
		URI uri  = customerClient.saveCustomerDto(customerDto);
		assertNotNull(customerDto);
		System.out.println(uri);
	}
	
	@Test
	void doUpdate() {
		CustomerDto customerDto  = CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Java").build();
		customerClient.performUpdate(UUID.randomUUID(), customerDto);
	}
	
	
	@Test
	void doDelete() {
		customerClient.delete(UUID.randomUUID());
	}

}
