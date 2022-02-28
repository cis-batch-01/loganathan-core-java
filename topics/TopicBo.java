package topics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicBo {
	public static List<Topic> filterByName(List<Topic> topicList, String name){
		List<Topic> resList=new ArrayList<Topic>();
		for(Topic topic:topicList) {
			if(topic.getTopicName().contains(name)) {
				resList.add(topic);
			}
		}
		
		
		return resList;
		
	}
	public static List<Topic>filterByModifiedDate(List<Topic> topicList,Date date){
		List<Topic> resList=new ArrayList<Topic>();
		for(Topic topic:topicList) {
			if(topic.getLastModifiedDate().after(date)||topic.getLastModifiedDate().equals(date)) {
				resList.add(topic);
			}
		}
		
		return resList;
		
	}
	

}
