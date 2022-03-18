package com.topicmodel;

import java.util.Date;

public class Topic {
	private Integer topic_Id;
	private String Topic_Name;
	private String description;
	private String content;
	private Date date;
	public Integer getTopic_Id() {
		return topic_Id;
	}
	public void setTopic_Id(Integer topic_Id) {
		this.topic_Id = topic_Id;
	}
	public String getTopic_Name() {
		return Topic_Name;
	}
	public void setTopic_Name(String topic_Name) {
		Topic_Name = topic_Name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Topic(Integer topic_Id, String topic_Name, String description, String content, Date date) {
		super();
		this.topic_Id = topic_Id;
		Topic_Name = topic_Name;
		this.description = description;
		this.content = content;
		this.date = date;
	}
	public Topic() {
		super();
		
	}
	
	public Topic(String topic_Name, String description, String content, Date date) {
		super();
		Topic_Name = topic_Name;
		this.description = description;
		this.content = content;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Topic [topic_Id=" + topic_Id + ", Topic_Name=" + Topic_Name + ", description=" + description
				+ ", content=" + content + ", date=" + date + "]";
	}
	
	

}
