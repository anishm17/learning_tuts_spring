package com.movie.visitor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.visitor.model.MovieDto;

@Repository
public interface MovieVisitorRepository extends JpaRepository<MovieDto, Integer> {

}
