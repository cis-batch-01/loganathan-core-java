package com.jdbcsampletopicservice;

import java.util.List;

import com.jdbcsampletopic.Topic;
import com.topicdao.TopicDAO;
import com.topicdao.TopicDAOImpl;

public class TopicServiceImpl implements TopicService {
	static TopicDAO topicdao=new TopicDAOImpl();
	public Topic getTopic(int id) {
		
		return topicdao.getTopic(id);
	}

	public List<Topic> getAllTopic() {
		
		return topicdao.getAllTopic();
	}

	public Topic saveTopic(Topic topic) {


		return topicdao.saveTopic(topic);
	}

	public Topic updateTopic(int id, Topic topic) {
		
		return topicdao.updateTopic(id, topic);
	}

	public Topic deleteTopic(int id) {
		
		return topicdao.deleteTopic(id);
	}

}
