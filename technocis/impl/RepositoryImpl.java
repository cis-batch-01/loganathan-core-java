package com.technocis.impl;

import java.util.ArrayList;
import java.util.List;

import com.technocis.lms.CourseModel;
import com.technocis.repo.Repository;

public class RepositoryImpl implements Repository {

	static List<CourseModel> courseList = new ArrayList<CourseModel>();

	static {
		courseList.add(new CourseModel(1, "java", "fullStack", "midlevel", "3 month", 4.8));
		courseList.add(new CourseModel(2, "c", "gaming", "devloper", "6 month", 4.5));
		courseList.add(new CourseModel(3, "angular", "web devlopement", "mid level", "3 month", 4.9));
		courseList.add(new CourseModel(4, "mongodb", "backend devloper", "midlevel", "3 month", 3.4));

	}

	public boolean addCourseClass(CourseModel course) {

		return courseList.add(course);
	}

	public boolean remove(int id) {

		CourseModel course = get(id);

		return courseList.remove(course);
	}

	public boolean updateCourseClass(int id, CourseModel course) {
	
		CourseModel old=get(id);
		courseList.remove(old);
		
		return courseList.add(course);
	}

	public List<CourseModel> getAllCourseClass() {

		return courseList;
	}

	public CourseModel get(int id) {
		CourseModel resList = null;

		for (CourseModel course : courseList) {
			if (course.getCourseId() == id) {

				resList = course;
			}
		}

		return resList;
	}

	public CourseModel getcourse(String data) {
		CourseModel resList1 = null;
		for (CourseModel course : courseList) {
			if (course.getCourseName().contains(data)) {

				resList1 = course;
			}
		}

		return resList1;
	}

}
