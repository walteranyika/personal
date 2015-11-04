package com.walter.projectholder;

public class Movie {
	private String title;
	private int image;
	private String genre;

	public Movie(String title, int image, String genre) {
		super();
		this.title = title;
		this.image = image;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public int getImage() {
		return image;
	}

	public String getGenre() {
		return genre;
	}

}
