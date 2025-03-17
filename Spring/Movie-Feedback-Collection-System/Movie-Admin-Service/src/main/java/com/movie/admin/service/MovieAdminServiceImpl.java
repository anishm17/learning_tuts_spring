package com.movie.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.admin.model.MovieDto;
import com.movie.admin.repository.MovieAdminRepository;

@Service
public class MovieAdminServiceImpl implements  MovieAdminService{

	@Autowired
	MovieAdminRepository  repository;

	@Override  
	public void save(MovieDto employee) {
		repository.save(employee);
	}

	public List<MovieDto>  findAll() {
		List<MovieDto>  movieDto =  repository.findAll();
		return movieDto;
	}

}
