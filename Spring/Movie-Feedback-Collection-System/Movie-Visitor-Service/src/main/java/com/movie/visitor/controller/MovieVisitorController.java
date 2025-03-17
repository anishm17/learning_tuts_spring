package com.movie.visitor.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.visitor.model.MovieDto;
import com.movie.visitor.service.MovieVisitorService;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("visitor")
@Validated
@Slf4j
public class MovieVisitorController {

	@Autowired
	private MovieVisitorService   movieVisitorService;


	@PutMapping("/feedback/{getMovieId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateMovieFeedback( @Valid @RequestBody MovieDto dto ,@Valid @PathVariable("getMovieId") Integer id) {
		log.info("Visitor's  Feedback  process  starts and  ends");
		movieVisitorService.updateMovieFeedback(dto ,id );
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


