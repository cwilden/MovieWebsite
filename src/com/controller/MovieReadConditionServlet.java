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
 * Servlet implementation class MovieReadConditionServlet
 */
@WebServlet("/Movie/Condition")
public class MovieReadConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieReadConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String condition = request.getParameter("condition");
		
		MovieService service = new MovieService();

		if(condition != null) {
			
			ArrayList<Movie> movies = service.getMoviesByCondition(condition);
			HttpSession session = request.getSession();
			session.setAttribute("movies", movies);
			request.getRequestDispatcher("../HTML/MoviePages/DisplayMovies.jsp").forward(request, response);
		
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
