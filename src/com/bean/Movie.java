package com.bean;

public class Movie {
	private int movieId;
	private String movieName;
	private int movieReleaseYear;
	private double moviePrice;
	private String condition;
	private String genre;
	private String review;
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int aId) {
		this.movieId = aId;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String aName) {
		this.movieName = aName;
	}
	
	public int getMovieReleaseYear() {
		return movieReleaseYear;
	}
	
	public void setMovieReleaseYear(int year) {
		this.movieReleaseYear = year;
	}
	
	public double getMoviePrice() {
		return moviePrice;
	}
	
	public void setMoviePrice(double aPrice) {
		this.moviePrice = aPrice;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String cond) {
		this.condition = cond;
	}
	
	public String getGenre()
	{
		return genre;
	}	
	
	public void setGenre(String gen) {
		this.genre = gen;
	}
	
	public String getReview()
	{
		return review;
	}	
	
	public void setReview(String review) {
		this.review = review;
	}
	
	
	@Override
	public String toString() {
		return "Movie #" + movieId + ": " + movieName + " was released in " + movieReleaseYear + " and is a " + genre + " genre. " + condition + " condition. " + '\n' + "Review: " + review + '\n' + " $" + moviePrice;
	}
}
