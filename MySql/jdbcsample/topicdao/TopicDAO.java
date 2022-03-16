package com.topicdao;

import java.util.List;

import com.jdbcsampletopic.Topic;

public interface TopicDAO {
	//1.getTopic
		public Topic getTopic(int id) ;

		//2.getAllTopic
		public List<Topic> getAllTopic();
		//3.saveTopic
		public Topic saveTopic(Topic topic);
		//4.update 
		public Topic updateTopic(int id,Topic topic);
		//5.delete
		public Topic deleteTopic(int id);

}
