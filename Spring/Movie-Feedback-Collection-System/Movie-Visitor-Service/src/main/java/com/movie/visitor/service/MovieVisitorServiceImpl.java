package com.movie.visitor.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.visitor.model.MovieDto;
import com.movie.visitor.repository.MovieVisitorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class MovieVisitorServiceImpl  implements MovieVisitorService{

	@Autowired
	MovieVisitorRepository  repository;

	@Autowired
	private RestTemplate   restTemplate;


	@HystrixCommand(fallbackMethod = "fallbackMovieDetail")
	public String updateMovieFeedback(MovieDto movieDto ,  Integer id) {
		log.info("Connecting movie-admin-service .. ");
		MovieDto  movieAdminDto =   restTemplate.getForObject("http://movie-admin-service/movie/get/"+id+"", MovieDto.class);
		log.info("Connected and  fetched movie-admin-service sucessfully ");
		if(Objects.nonNull(movieAdminDto)) {
			movieAdminDto.setMovieId(movieDto.getMovieId());
			movieAdminDto.setMovieFeedback(movieDto.getMovieFeedback());
			repository.save(movieAdminDto);
		}
		return "Success";
	}
	

    public  String  fallbackMovieDetail(MovieDto movieDto ,  Integer id){
    	return  "Movie Service not  available,try again later";
	}
	

}
