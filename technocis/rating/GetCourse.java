package com.technocis.rating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.technocis.lms.CourseModel;

public class GetCourse {

	public List<CourseModel> findGoodCourse(List<CourseModel> courseList) {
		List<CourseModel> resList = new ArrayList<CourseModel>();
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getRating() > 3.5) {
				resList.add(courseList.get(i));
			}
		}
		Collections.sort(resList, Collections.reverseOrder());
		return resList;

	}

	public List<CourseModel> findpoorCourse(List<CourseModel> courseList) {
		List<CourseModel> resList = new ArrayList<CourseModel>();
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getRating() < 3.5) {
				resList.add(courseList.get(i));
			}
		}
		Collections.sort(resList);
		return resList;

	}

	public List<CourseModel> findInterestCourse(List<CourseModel> courseList, String input) {
		List<CourseModel> resList = new ArrayList<CourseModel>();
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseName().toLowerCase().contains(input.toLowerCase())) {
				resList.add(courseList.get(i));
			}
		}
		Collections.sort(resList);
		return resList;

	}

}
