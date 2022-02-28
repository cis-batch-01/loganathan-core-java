package topics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Topic implements Comparable<Topic> {
	
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
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + topicId;
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
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (topicId != other.topicId)
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
		return String.format("%-15s%-16s%-16s%-15s%-15s%-15s\n", topicId,topicName, description,content,
		sdf.format(createDate),sdf.format(lastModifiedDate));
	}
	public static Topic createTopic(String stringdata) throws NumberFormatException, ParseException {
SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		String [] data=stringdata.split(",");
		Topic topic=new Topic(Integer.parseInt(data[0]),data[1],data[2],data[3],sdf.parse(data[4]),sdf.parse(data[5]));
		return topic;
	}
	public int compareTo(Topic o) {//o1.compareTo(02)
		// TODO Auto-generated method stub
		return this.getTopicName().compareTo(o.topicName);
	}
	

}
