package com.movie.visitor.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Integer  movieId;

	@Column(name = "movie_name")
	private String  movieName;

	@Column(name = "imdb_rating")
	private Double  imdbRating ;

	@Column(name = "movie_feedback")
	@NotBlank
	private  String   movieFeedback;

	@Column(name = "release_year")
	private  Integer  releaseYear;


}
