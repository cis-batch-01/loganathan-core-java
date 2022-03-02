package com.interfaceSample;

import java.util.List;

public interface Repository {

	public boolean add(CourseClass course);
	public List<CourseClass> getAllCourseClass();
	public CourseClass get(int id);
	public boolean remove(int id);
	public boolean update(int id, String updateData);
	//public boolean update(int id);
	
}
