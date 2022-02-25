package com.technocis.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicClass implements Comparable<MusicClass> {
	private String title;
	 private String genre;
	 private Date duration;
	 private double  rating;
	 
	 
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
		return String.format("%-15s%-20s%-10s%-6s\n", title,genre,sdf.format(duration),rating);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public MusicClass(String title, String genre, Date duration, double rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	public MusicClass() {
		super();
		//  Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MusicClass other = (MusicClass) obj;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
		
			
		public int compareTo(MusicClass o) {
			//  Auto-generated method stub
			 return this.duration.compareTo(o.duration);
		}
		}
		

	 

