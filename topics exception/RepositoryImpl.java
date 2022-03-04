package com.topics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;





public class RepositoryImpl implements Repository {
	static List<Chapter> chapterList =new ArrayList<Chapter>();
	static {
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		

		try {
//			
			chapterList.add(new Chapter(1, "c", "game", "fullstack", "english", sdf.parse("12-03-2003")));
			chapterList.add(new Chapter(2, "java", "spring", "middle", "english", sdf.parse("12-04-2003")));
			chapterList.add(new Chapter(3, "Angular", "web", "fullstack", "english", sdf.parse("12-08-2003")));
		} catch (ParseException e) {
			
            System.out.println("data wrong");
		}
	}
	public boolean add(Chapter chapter) {
		chapterList.add(chapter);
		return true;
	}
	public boolean remove(int id) {
		Chapter chapter=get(id);
		return chapterList.remove(chapter);
	}
	public boolean update(int id, Chapter chapter) {
		chapterList.remove(id-1);
		return chapterList.add(chapter);
	}
	public List<Chapter> getAllChapter() {
		
		return chapterList;
	}
	public Chapter get(int id) {
     Chapter resList=null;
		
		for(Chapter chapter:chapterList)
		{
			if(chapter.getChapterId()==(id)) {
				resList=chapter;
			}
		}
		return resList;
	}
}
