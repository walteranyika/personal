package com.walter.locker;

public class Movie {
 private String password;
 private String site;
 private String id;
 private String date_added;
 public Movie(String id,String site,String password,String date_added)
 {
	this.password=password;
	this.site =site;
	this.id=id;
	this.date_added=date_added;
 }
 public String getPassword() {
	return password;
 }
 public String getSite() {
	return site;
}
 public String getDate_added() {
	return date_added;
}
 public String getId() {
	return id;
}
}
