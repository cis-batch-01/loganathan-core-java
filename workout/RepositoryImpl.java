package com.workout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.interfaceSample.CourseClass;

public class RepositoryImpl implements Repository{

	
	static List<Topic> topicList =new ArrayList<Topic>();
	static {
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		

		try {
			topicList.add(new Topic(1, "c", "game", "fullstack", "english", sdf.parse("12-03-2003")));
			topicList.add(new Topic(2, "java", "spring", "middle", "english", sdf.parse("12-04-2003")));
			topicList.add(new Topic(3, "c++", "game", "fullstack", "english", sdf.parse("12-08-2003")));
		} catch (ParseException e) {
			
            System.out.println("data wrong");
		}
	}
	
	
	public boolean add(Topic topic ) {
			
			topicList.add(topic);
		
		return true;
	}

	public boolean remove(int id) {
		Topic topic = get(id);
	topicList.remove(topic);
		
		return true;
	}

	public boolean update(int id, Topic topic) {
		 Topic topic1 =get(id);
		 topicList.remove(id-1);
		
		return topicList.add(topic1); 
	}

	public List<Topic> getAllTopic() {
		
		return topicList ;
	}

	public Topic get(int id) {
		Topic topic = get(id);
		Topic resList=null;
		for(Topic topic1:topicList)
		{
			if(topic1.getTopicId()==id) {
				resList=topic1;
			}
		}
		return resList;
	}

}
