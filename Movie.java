package com.technocis.sample;

public class Movie {
  
	 private String name;
	 private double boxoffice;
	 private double rating;
	 private double  budget;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(String name, double boxoffice, double rating, double budget) {
		super();
		this.name = name;
		this.boxoffice = boxoffice;
		this.rating = rating;
		this.budget = budget;
	}
	public double getBoxoffice() {
		return boxoffice;
	}
	public void setBoxoffice(double boxoffice) {
		this.boxoffice = boxoffice;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Movie() {
		super();
		//  Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", boxoffice=" + boxoffice + ", rating=" + rating + ", budget=" + budget + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Movie other = (Movie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}
	
}
