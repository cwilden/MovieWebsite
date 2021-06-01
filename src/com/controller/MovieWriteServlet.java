package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Movie;
import com.service.MovieService;
@WebServlet("/Movie")
public class MovieWriteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public MovieWriteServlet() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		request.getRequestDispatcher("/Movie/List").forward(request, response);

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(request.getParameter("movie_name"));
		System.out.println(request.getParameter("movie_releaseyear"));
		System.out.println(request.getParameter("movie_price"));
		System.out.println(request.getParameter("movie_condition"));
		System.out.println(request.getParameter("movie_genre"));
		System.out.println(request.getParameter("movie_review"));
		
		Movie movie = new Movie();
		movie.setMovieName(request.getParameter("movie_name"));
		movie.setMovieReleaseYear(Integer.parseInt(request.getParameter("movie_releaseyear")));
		movie.setMoviePrice(Double.parseDouble(request.getParameter("movie_price")));
		movie.setCondition(request.getParameter("movie_condition"));
		movie.setGenre(request.getParameter("movie_genre"));
		movie.setReview(request.getParameter("movie_review"));
		
		String action = request.getParameter("action");

		MovieService service = new MovieService();
		if(action.equals("add")) {
		service.insert(movie);
		}else {
			movie.setMovieId(Integer.parseInt(request.getParameter("id")));
			service.update(movie);
		}
		request.getRequestDispatcher("/Movie/List").forward(request, response);
		
		
	}

}
