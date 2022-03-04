package com.topics;

import java.util.List;



public interface Repository {
	public boolean add(Chapter chapter);
    public boolean remove(int id);
    public boolean update(int id,Chapter chapter);
    public List<Chapter> getAllChapter();
    public Chapter get(int id);
	
}
 