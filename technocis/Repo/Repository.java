package com.technocis.repo;

import java.util.List;

import com.technocis.lms.CourseClass;

public interface Repository {

	public boolean addCourseClass(CourseClass course);

	public boolean remove(int id);

	public boolean updateCourseClass(int id, CourseClass course);

	public List<CourseClass> getAllCourseClass();

	public CourseClass get(int id);

	public CourseClass getcourse(String data);  //user search get course
}
