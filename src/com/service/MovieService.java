package com.service;

import java.util.ArrayList;

import com.bean.Movie;
import com.dal.MovieDAO;

public class MovieService{
	
	private MovieDAO dao = new MovieDAO();
	
	public Movie insert(Movie obj) {
		return dao.insert(obj);
	}
	
	public void update(Movie obj) {
		dao.update(obj);
	}
	
	public ArrayList<Movie> getAll()
	{
		return dao.getAll();
	}
	
	public ArrayList<Movie> getMoviesByGenre(String genre){
		return dao.getMoviesByGenre(genre);
	}
	
	public ArrayList<Movie> getMoviesByCondition(String condition){
		return dao.getMoviesByCondition(condition);
	}
	
	public Movie getById(int id) {
		return dao.getById(id);
	}
	

}
