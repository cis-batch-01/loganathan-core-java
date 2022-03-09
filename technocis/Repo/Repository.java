package com.technocis.repo;

import java.util.List;

import com.technocis.lms.CourseModel;

public interface Repository {

	public boolean addCourseClass(CourseModel course);

	public boolean remove(int id);

	public boolean updateCourseClass(int id, CourseModel course);

	public List<CourseModel> getAllCourseClass();

	public CourseModel get(int id);

	public CourseModel getcourse(String data); // user search get course
}
