package topics;

import java.util.Comparator;

public class DateComparator implements Comparator<Topic> {

	public int compare(Topic o1, Topic o2) {
		
		return o1.getCreateDate().compareTo(o2.getCreateDate());
	}

	
}
