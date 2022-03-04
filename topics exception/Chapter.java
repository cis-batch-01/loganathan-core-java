package com.topics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Chapter {
	private Integer chapterId;
	private String topicName;
	private String topicContent;
	private String description;
	private String language;
	private Date createdDate;
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
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
	public Chapter(Integer chapterId, String topicName, String topicContent, String description, String language,
			Date createdDate) {
		super();
		this.chapterId = chapterId;
		this.topicName = topicName;
		this.topicContent = topicContent;
		this.description = description;
		this.language = language;
		this.createdDate = createdDate;
	}
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterId == null) ? 0 : chapterId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((topicContent == null) ? 0 : topicContent.hashCode());
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
		Chapter other = (Chapter) obj;
		if (chapterId == null) {
			if (other.chapterId != null)
				return false;
		} else if (!chapterId.equals(other.chapterId))
			return false;
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
		
		return String.format("%-15s%-15s%-15s%-15s%-15s%-15s\n",chapterId,topicName,topicContent,description,language,sdf.format(createdDate));
	}
//
	public static Chapter createChapter(String updateData)throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String [] splittedData =updateData.split(",");
		Chapter chapter=new Chapter(Integer.parseInt(splittedData[0]),splittedData[1],splittedData[2],splittedData[3],splittedData[4],sdf.parse(splittedData[5]));
		return chapter;
		
	}
	
}
