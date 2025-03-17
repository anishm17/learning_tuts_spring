package com.movie.admin.service;

import java.util.List;

import com.movie.admin.model.MovieDto;

public interface MovieAdminService {

	void save(MovieDto employee);

	List<MovieDto>  findAll();

}
