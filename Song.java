package com.technocis.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Song {
	private String title;
	 private String genre;
	 private Date duration;
	 private double  rating;
	 
	 
	 
	public Song() {
		super();
		//  Auto-generated constructor stub
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
	public Song(String title, String genre, Date duration, double rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	@Override
	public String toString() {
		SimpleDateFormat sd=new SimpleDateFormat("mm:ss");
		return "title=" + title + "\n genre=" + genre + "\n duration=" + sd.format(duration) + "\n rating=" + rating ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
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
		Song other = (Song) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	 
	 
}