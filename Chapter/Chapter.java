package com.Chapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.phones.Phone;

public class Chapter {
	private int chapterId;
	private String chapterName;
	private String chapterContent;
	private String description;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterContent() {
		return chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Chapter(int chapterId, String chapterName, String chapterContent, String description) {
		super();
		this.chapterId = chapterId;
		this.chapterName = chapterName;
		this.chapterContent = chapterContent;
		this.description = description;
	}

	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterContent == null) ? 0 : chapterContent.hashCode());
		result = prime * result + chapterId;
		result = prime * result + ((chapterName == null) ? 0 : chapterName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		if (chapterContent == null) {
			if (other.chapterContent != null)
				return false;
		} else if (!chapterContent.equals(other.chapterContent))
			return false;
		if (chapterId != other.chapterId)
			return false;
		if (chapterName == null) {
			if (other.chapterName != null)
				return false;
		} else if (!chapterName.equals(other.chapterName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		 return String.format("%-15s%-16s%-16s%-15s\n", chapterId,chapterName,chapterContent,description);
	}


	public static Chapter createChapter(String stringdata) throws NumberFormatException, ParseException {
		
				String [] data=stringdata.split(",");
				//Chapter chapter=new Chapter(Integer.parseInt(data[0]),data[1],data[2],data[3]));
				Chapter chapter=new Chapter(Integer.parseInt(data[0]), data[1], data[2], data[3]);
				return chapter;
			}

}
