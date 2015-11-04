package com.walter.searchablelist;

public class Movie {
  private String Name,Genre,Year;
  public Movie(String Name, String Genre, String Year) 
  {
	  this.Name=Name;
	  this.Year=Year;
	  this.Genre=Genre;
  }
  public String getGenre() {
	return Genre;
  }
  public String getName() {
	return Name;
  }
  public String getYear() {
	return Year;
  }
}
