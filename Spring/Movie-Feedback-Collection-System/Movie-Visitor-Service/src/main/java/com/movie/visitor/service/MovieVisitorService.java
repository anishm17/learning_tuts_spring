package com.movie.visitor.service;

import com.movie.visitor.model.MovieDto;

public interface MovieVisitorService {

	String updateMovieFeedback(MovieDto movieDto, Integer id);

}
