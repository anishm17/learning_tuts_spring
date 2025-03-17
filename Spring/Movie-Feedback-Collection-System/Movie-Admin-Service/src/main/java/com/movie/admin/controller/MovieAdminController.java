package com.movie.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.admin.model.MovieDto;
import com.movie.admin.service.MovieAdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("movie")
@Validated
@Slf4j
public class MovieAdminController {

	@Autowired
	private MovieAdminService   movieAdminService;

	@PostMapping("/add")
	public ResponseEntity  createMovieData(@Valid @RequestBody  MovieDto  movie) {
		log.info("movie  creation  process  starts");
		movieAdminService.save(movie);
		log.info("movie  creation  process  ends");
		return  new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/get/{getMovieId}")
	public  MovieDto  getMoviesData(@Valid @PathVariable("getMovieId") Integer id) {
		log.info("movie  fetch process  starts");
		List<MovieDto>  movieDto  =   movieAdminService.findAll();
		log.info("movie  fetch process  starts");
		return  movieDto.stream().filter(action -> action.getMovieId().equals(id)).findAny().orElse(null);
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


