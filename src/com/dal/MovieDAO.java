package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.Movie;
import com.utilities.DbCon;

public class MovieDAO implements DAOInterface<Movie>{
	private static String table="CW1878571_MOVIE";
	
	public ArrayList<Movie> getAll(){
		ArrayList<Movie> movies = new ArrayList<>();
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "select * from " + table;
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery(qry);
			while(rs.next()) {
				Movie obj = new Movie();
				obj.setMovieId(rs.getInt(1));
				obj.setMovieName(rs.getString(2));
				obj.setMovieReleaseYear(rs.getInt(3));
				obj.setMoviePrice(rs.getDouble(4));
				obj.setCondition(rs.getString(5));
				obj.setGenre(rs.getString(6));
				obj.setReview(rs.getString(7));
				
				movies.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
		return movies;
	}

	public Movie insert(Movie obj) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "insert into " + table + " (movie_name, movie_releaseyear, movie_price, movie_condition, movie_genre, movie_review) values (?, ?,?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,  obj.getMovieName());
			st.setInt(2, obj.getMovieReleaseYear());
			st.setDouble(3, obj.getMoviePrice());
			st.setString(4,  obj.getCondition());
			st.setString(5, obj.getGenre());
			st.setString(6, obj.getReview());
			st.executeUpdate();		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
		return obj;
	}
	
	public void update(Movie obj) {
		System.out.println(obj);
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "update " + table + " set movie_name= ?, movie_releaseyear =?, movie_price = ?, movie_condition =?, movie_genre = ?, movie_review = ? where movie_id = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,  obj.getMovieName());
			st.setInt(2, obj.getMovieReleaseYear());
			st.setDouble(3, obj.getMoviePrice());
			st.setString(4, obj.getCondition());
			st.setString(5, obj.getGenre());
			st.setString(6, obj.getReview());
			st.setInt(7, obj.getMovieId());
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
	}
	
	public Movie getById(int id) {
		Movie obj = new Movie();
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "select * from " + table + " where movie_id = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1,  id);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				obj.setMovieId(rs.getInt(1));
				obj.setMovieName(rs.getString(2));
				obj.setMovieReleaseYear(rs.getInt(3));
				obj.setMoviePrice(rs.getDouble(4));
				obj.setCondition(rs.getString(5));
				obj.setGenre(rs.getString(6));
				obj.setReview(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return obj;
	}
	
	public ArrayList<Movie> getMoviesByGenre(String genre){
		ArrayList<Movie> movies = new ArrayList<>();
		
		Connection con = DbCon.getConnection();
		try {
			String qry = "select * from " + table + " where movie_genre = '" + genre + "'";
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery(qry);
			
			while(rs.next()) {
				Movie obj = new Movie();
				obj.setMovieId(rs.getInt(1));
				obj.setMovieName(rs.getString(2));
				obj.setMovieReleaseYear(rs.getInt(3));
				obj.setMoviePrice(rs.getDouble(4));
				obj.setCondition(rs.getString(5));
				obj.setGenre(rs.getString(6));
				obj.setReview(rs.getString(7));
				movies.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return movies;
	}

	public ArrayList<Movie> getMoviesByCondition(String condition){
		ArrayList<Movie> movies = new ArrayList<>();
		Connection con = DbCon.getConnection();
		
		try {
			
			String qry = "select * from " + table + " where movie_condition = '"+ condition + "'";
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery(qry);
			
			while(rs.next()) {
				Movie obj = new Movie();
				obj.setMovieId(rs.getInt(1));
				obj.setMovieName(rs.getString(2));
				obj.setMovieReleaseYear(rs.getInt(3));
				obj.setMoviePrice(rs.getDouble(4));
				obj.setCondition(rs.getString(5));
				obj.setGenre(rs.getString(6));
				obj.setReview(rs.getString(7));
				movies.add(obj);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
		return movies;
	}
	
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "delete from " + table + " where movie_id = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, id);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
	}
	
	
	
	
}
