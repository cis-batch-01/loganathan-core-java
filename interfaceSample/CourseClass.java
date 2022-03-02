package com.interfaceSample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseClass {

	private Integer id;
	private String title;
	private String description;
	private String skillLevel;
	private String language;
	private Double rating;
	private Date createdDate;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public String getSkillLevel() {
		return skillLevel;
	}


	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
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


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public CourseClass() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CourseClass(int id, String title, String description, String skillLevel, String language, Double rating,
			Date createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.skillLevel = skillLevel;
		this.language = language;
		this.rating = rating;
		this.createdDate = createdDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((skillLevel == null) ? 0 : skillLevel.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		return String.format("%-15s%-20s%-10s%-15s%-15s%-15s%-15s\n", id,title,description,skillLevel,language,rating,sdf.format(createdDate));
	
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseClass other = (CourseClass) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
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
		if (skillLevel == null) {
			if (other.skillLevel != null)
				return false;
		} else if (!skillLevel.equals(other.skillLevel))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public static CourseClass createCourse(String data) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String[] splitted=data.split(",");
		CourseClass course=new CourseClass(Integer.parseInt(splitted[0]),splitted[1], splitted[2], splitted[3],splitted[4],Double.parseDouble(splitted[5]) ,sdf.parse(splitted[6]));
		return course;
	}


	public static void remove(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
