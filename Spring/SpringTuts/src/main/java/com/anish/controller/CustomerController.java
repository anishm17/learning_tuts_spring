package com.anish.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anish.model.CustomerDto;
import com.anish.service.CustomerService;

@Validated
@RequestMapping("api/anish/customer/")
@RestController
public class CustomerController {
	private final CustomerService  customerservice;
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	@GetMapping("/{getId}")
	public  ResponseEntity<CustomerDto>  getId(@Valid @PathVariable("getId") UUID id) {
		return new ResponseEntity<>(customerservice.getCustomerID(id), HttpStatus.OK);
	}

	@PostMapping	
	public ResponseEntity doPost(@Valid @RequestBody CustomerDto dto ){
		CustomerDto cdto =customerservice.doHandlePost(dto);
		HttpHeaders  headers =  new HttpHeaders();
		headers.add("Location", "api/anish/customer/"+ cdto.getId().toString());
		return new ResponseEntity(headers,	HttpStatus.CREATED	);

	}	


	@PutMapping("/{getId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void doPut( @Valid @RequestBody CustomerDto dto ,@PathVariable("getId") UUID id) {
		customerservice.doUpdate(dto,id);
	}

	@DeleteMapping("/{getId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void doDelete(@PathVariable("getId") UUID id ) {
		customerservice.doDelete(id);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List>  validateErrorHandle(ConstraintViolationException e){
		List<String>  errorList  =  new ArrayList<>();
		e.getConstraintViolations().forEach(constraints -> {
			errorList.add(constraints.getMessage());
		});
		return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
	}

}
