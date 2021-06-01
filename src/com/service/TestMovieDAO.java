package com.service;

import com.dal.MovieDAO;

import java.util.ArrayList;

import com.bean.Movie;

public class TestMovieDAO {
	public static void main(String[] args) {
		MovieDAO dao = new MovieDAO();
		Movie movie = new Movie();
		movie.setMovieId(3);
		movie.setMovieName("Halloween");
		movie.setMovieReleaseYear(1978);
		movie.setMoviePrice(2.99);
		movie.setCondition("used");
		movie.setGenre("horror");
		movie.setReview("okay");
//		dao.insert(movie);
//		
//		ArrayList<Movie> movies =dao.getAll();
//		for(Movie mov: movies) {
//			System.out.println(mov);
//		}
//		
//		dao.deleteById(2);
		dao.update(movie);
		ArrayList<Movie> movies =dao.getAll();
		for(Movie mov: movies) {
			System.out.println(mov);
		}
		
		
	}
}
