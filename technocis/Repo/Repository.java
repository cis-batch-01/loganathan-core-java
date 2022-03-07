package com.technocis.Repo;

import java.util.List;

import com.technocis.LMS.CourseClass;

public interface Repository {

	public boolean addCourseClass(CourseClass course);
	public boolean remove(int id);
	public boolean updateCourseClass(int id,CourseClass course);
	public List<CourseClass> getAllCourseClass();
	public CourseClass get(int id);
	
}
