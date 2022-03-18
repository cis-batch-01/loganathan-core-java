package com.topicdao;

import java.util.List;

import com.topicmodel.Topic;

public interface TopicDAO {

	public Topic getTopic(int id);
	public List<Topic> getAllTopic();
	public Topic addTopic(Topic topic);
	public Topic updateTopic(int id,Topic topic);
	public Topic deleteTopic(int id);
}
