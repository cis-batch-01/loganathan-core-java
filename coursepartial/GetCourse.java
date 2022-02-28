package com.satsun.coursepartial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetCourse {
	public List<Course3> findCourse(List<Course3> courseList)
	{
		List<Course3> resList=new ArrayList<Course3>();
//		for(Course3 course:courseList)
//		{
//			if(course.getRating()>=(rating))
//			{
//				resList.add(course);
//			}
//		}
		
		Collections.sort(courseList,Collections.reverseOrder());
		for(int i=0;i<=1;i++) {
			resList.add(courseList.get(i));
		}
		return resList;

}

	
	
}
