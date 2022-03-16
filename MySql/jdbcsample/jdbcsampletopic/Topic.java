package com.jdbcsampletopic;

import java.util.Date;

public class Topic {
	private int topicId;
	private String topicName;
	private String description;
	private  String content;
	private Date createDate;
	private Date lastModifiedDate;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Topic(int topicId, String topicName, String description, String content, Date createDate,
			Date lastModifiedDate) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.description = description;
		this.content = content;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public Topic(String topicName, String description, String content, Date createDate, Date lastModifiedDate) {
		super();
		this.topicName = topicName;
		this.description = description;
		this.content = content;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", description=" + description + ", content="
				+ content + ", createDate=" + createDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
}
