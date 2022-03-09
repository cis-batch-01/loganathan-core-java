package com.technocis.lms;

import java.text.ParseException;

public class CourseModel implements Comparable<CourseModel> {

	private Integer courseId;
	private String courseName;
	private String courseContent;
	private String skillLevel;
	private String duration;
	private Double rating;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public CourseModel(Integer courseId, String courseName, String courseContent, String skillLevel, String duration,
			Double rating) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseContent = courseContent;
		this.skillLevel = skillLevel;
		this.duration = duration;
		this.rating = rating;
	}

	public CourseModel() {
		super();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseContent == null) ? 0 : courseContent.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((skillLevel == null) ? 0 : skillLevel.hashCode());
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
		CourseModel other = (CourseModel) obj;
		if (courseContent == null) {
			if (other.courseContent != null)
				return false;
		} else if (!courseContent.equals(other.courseContent))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
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
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-20s%-20s%-20s%-20s%-20s\n", courseId, courseName, courseContent, skillLevel,
				duration, rating);

	}

	public static CourseModel createCourseClass(String stringdata) throws NumberFormatException, ParseException {

		String[] data = stringdata.split(",");
		CourseModel course = new CourseModel(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4],
				Double.parseDouble(data[5]));
		return course;
	}

	public int compareTo(CourseModel o) {

		return this.rating.compareTo(o.rating);
	}

}
