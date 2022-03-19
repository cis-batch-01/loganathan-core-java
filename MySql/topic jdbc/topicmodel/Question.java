package com.topicmodel;

public class Question {
	private Integer question_id;
	private String question_content;
	private String topic_name;
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public Question(Integer question_id, String question_content, String topic_name) {
		super();
		this.question_id = question_id;
		this.question_content = question_content;
		this.topic_name = topic_name;
	}
	public Question() {
		super();
		
	}
	
	public Question(String question_content, String topic_name) {
		super();
		this.question_content = question_content;
		this.topic_name = topic_name;
	}
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question_content=" + question_content + ", topic_name="
				+ topic_name + "]";
	}

}
