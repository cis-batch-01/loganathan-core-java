package com.satsun.coursepartial;

import java.util.ArrayList;

import java.util.List;



public class CourseBo1 {
	public List<Course2> findCast(List<Course2> courseList,String title)
	{
		List<Course2> resList=new ArrayList<Course2>();
		for(int i=0;i<courseList.size();i++)
		{
			if(title.equals(courseList.get(i).getTitle()))
			{
				resList.add(courseList.get(i));
			}
		}
		
		return resList;
	}
	
	public List<Course2> findCast(List<Course2> courseList,Double rating)
	{
		List<Course2> resList=new ArrayList<Course2>();
		for(Course2 course:courseList)
		{
			if(course.getRating().equals(rating))
			{
				resList.add(course);
			}
		}
		return resList;

}
}
