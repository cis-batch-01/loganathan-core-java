package com.technocis.impl;

import java.util.ArrayList;
import java.util.List;

import com.technocis.lms.CourseClass;
import com.technocis.repo.Repository;

public class RepositoryImpl implements Repository {

	static List<CourseClass> courseList = new ArrayList<CourseClass>();

	static {
		courseList.add(new CourseClass(1, "java", "fullStack", "midlevel", "3 month", 4.8));
		courseList.add(new CourseClass(2, "c", "gaming", "devloper", "6 month", 4.5));
		courseList.add(new CourseClass(3, "angular", "web devlopement", "mid level", "3 month", 4.9));
		courseList.add(new CourseClass(4, "mongodb", "backend devloper", "midlevel", "3 month", 3.4));

	}

	public boolean addCourseClass(CourseClass course) {

		return courseList.add(course);
	}

	public boolean remove(int id) {

		CourseClass course = get(id);

		return courseList.remove(course);
	}

	public boolean updateCourseClass(int id, CourseClass course) {
		courseList.remove(id - 1);
		return courseList.add(course);
	}

	public List<CourseClass> getAllCourseClass() {

		return courseList;
	}

	public CourseClass get(int id) {
		CourseClass resList = null;

		for (CourseClass course : courseList) {
			if (course.getCourseId() == id) {

				resList = course;
			}
		}

		return resList;
	}

	public CourseClass getcourse(String data) {
		CourseClass resList1 = null;
		for (CourseClass course : courseList) {
			if (course.getCourseName().contains(data)) {

				resList1 = course;
			}
		}

		return resList1;
	}

}
