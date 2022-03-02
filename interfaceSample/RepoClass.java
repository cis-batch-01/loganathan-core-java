package com.interfaceSample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public  class RepoClass implements Repository {
	public static List<CourseClass> courseList = new ArrayList<CourseClass>();
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			
			courseList.add(new CourseClass(1,"java","spring","middle","english",4.5,sdf.parse("09-08-1996")));
			courseList.add(new CourseClass(2,"c","full","middle","english",4.3,sdf.parse("09-08-1988")));
			courseList.add(new CourseClass(3,"c++","full","middle","english",4.2,sdf.parse("09-08-1992")));
		} catch (ParseException e) {
			
			System.out.println(" Data is worng");
		}

	}
	public boolean add(CourseClass course) {
		
		return courseList.add(course);
	}

	
	public CourseClass get(int id) {
		CourseClass resList=null;
		for(CourseClass course:courseList) {
			if(course.getId()==(id)) {
				resList=course;
			}
		}
		return resList;
	}
	public boolean remove(int id) {
		CourseClass course = get(id);
		return courseList.remove(course);
	
	}
	public boolean update(int id, String updateData) {
		CourseClass course = get(id);
		CourseClass.remove(id - 1);
		return courseList.add(course);
		
	}
	public List<CourseClass> getAllCourseClass() {
		// TODO Auto-generated method stub
		return courseList;
	}


	

	

}
