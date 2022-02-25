package com.technocis.sample;

import java.util.Comparator;

public class RatingCompartor implements Comparator<MusicClass> {
	public int compare(MusicClass o1, MusicClass o2) {
		//  Auto-generated method stub
		if(o1.getRating()==o2.getRating())
		{
			return 0;
		}
		else if(o1.getRating()>o2.getRating())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

}
