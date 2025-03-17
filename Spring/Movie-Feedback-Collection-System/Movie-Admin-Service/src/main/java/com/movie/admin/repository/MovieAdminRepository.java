package com.movie.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.admin.model.MovieDto;

public interface MovieAdminRepository extends JpaRepository<MovieDto, Integer> {

}
