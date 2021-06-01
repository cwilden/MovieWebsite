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

/**
 * Servlet implementation class MovieReadServlet
 */
@WebServlet("/Movie/List")
public class MovieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		
		MovieService service = new MovieService();

		if(idString != null) {
			Integer id = Integer.parseInt(idString);
			Movie movie = service.getById(id);
			HttpSession session = request.getSession();
			session.setAttribute("movie", movie);
			request.getRequestDispatcher("../HTML/MoviePages/UpdateMovie.jsp").forward(request, response);
		
		}else {
			ArrayList<Movie> movies = service.getAll();
			HttpSession session = request.getSession();
			session.setAttribute("movies", movies);
			request.getRequestDispatcher("../HTML/MoviePages/DisplayMovies.jsp").forward(request, response);
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
