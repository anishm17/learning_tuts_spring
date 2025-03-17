package com.anish.service;

import java.util.UUID;

import com.anish.model.CustomerDto;


public interface CustomerService  {

	CustomerDto getCustomerID(UUID id);

	CustomerDto doHandlePost(CustomerDto dto);

	void doUpdate( CustomerDto dto,UUID id);

	void doDelete(UUID id);
	
}
