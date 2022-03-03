package com.workout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Topic {
	private Integer topicId;
	private String topicName;
	private String topicContent;
	private String description;
	private String language;
	private Date createdDate;
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Topic(Integer topicId, String topicName, String topicContent, String description, String language,
			Date createdDate) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.topicContent = topicContent;
		this.description = description;
		this.language = language;
		this.createdDate = createdDate;
	}
	public Topic() {
		super();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((topicContent == null) ? 0 : topicContent.hashCode());
		result = prime * result + ((topicId == null) ? 0 : topicId.hashCode());
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (topicContent == null) {
			if (other.topicContent != null)
				return false;
		} else if (!topicContent.equals(other.topicContent))
			return false;
		if (topicId == null) {
			if (other.topicId != null)
				return false;
		} else if (!topicId.equals(other.topicId))
			return false;
		if (topicName == null) {
			if (other.topicName != null)
				return false;
		} else if (!topicName.equals(other.topicName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		return String.format("%-15s%-15s%-15s%-15s%-15s%-15s\n",topicId,topicName,topicContent,description,language,sdf.format(createdDate));
	}
	
	

}
