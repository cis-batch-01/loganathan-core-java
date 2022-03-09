package com.technocis.rating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.technocis.lms.CourseClass;

public class GetCourse {

	public List<CourseClass> findGoodCourse(List<CourseClass> courseList) {
		List<CourseClass> resList = new ArrayList<CourseClass>();
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getRating() > 3.5) {
				resList.add(courseList.get(i));
			}
		}
		Collections.sort(resList, Collections.reverseOrder());
		return resList;

	}

	public List<CourseClass> findpoorCourse(List<CourseClass> courseList) {
		List<CourseClass> resList = new ArrayList<CourseClass>();
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getRating() < 3.5) {
				resList.add(courseList.get(i));
			}
		}
		Collections.sort(resList);
		return resList;

	}

	public List<CourseClass> findInterestCourse(List<CourseClass> courseList, String input) {
		List<CourseClass> resList = new ArrayList<CourseClass>();
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseName().contains(input)) {
				resList.add(courseList.get(i));
			}
		}
		Collections.sort(resList);
		return resList;

	}

}
