package com.satsun.coursepartial;

import java.text.ParseException;

public class Course3 implements Comparable<Course3>  {
	private String title;
	private String description;
	private String language;
	private Double rating;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Course3(String title, String description, String language, Double rating) {
		super();
		this.title = title;
		this.description = description;
		this.language = language;
		this.rating = rating;
	}
	public Course3() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course3 other = (Course3) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%-15s%-20s%-10s%-6s\n", title,description,language,rating);
	}
	
	
	
	public static Course3 createCourse(String data) throws ParseException{
		//  Auto-generated method 
		String[] splitted=data.split(",");
		Course3 course=new Course3(splitted[0], splitted[1], splitted[2], Double.parseDouble(splitted[3]));
		return course;
		
	}
	public int compareTo(Course3 o) {
		// TODO Auto-generated method stub
		return this.rating.compareTo(o.rating);
	}
}
