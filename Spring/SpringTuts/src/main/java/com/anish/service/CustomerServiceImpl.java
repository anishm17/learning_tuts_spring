package com.anish.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.anish.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl  implements  CustomerService {
	@Override
	public CustomerDto getCustomerID(UUID id) {
		return  CustomerDto.builder().
				id(UUID.randomUUID()).
				name("Anish Mohan").
				build();
	}

	@Override
	public CustomerDto doHandlePost(CustomerDto dto) {
		return CustomerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void doUpdate( CustomerDto dto,UUID id) {
		log.debug("Update Initiated");

	}

	@Override
	public void doDelete(UUID id) {
		log.debug("Delete Initiated");

	}
}
