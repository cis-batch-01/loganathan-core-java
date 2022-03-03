package com.workout;

import java.util.List;

public interface Repository {
        public boolean add(Topic topic);
        public boolean remove(int id);
        public boolean update(int id,Topic topic);
        public List<Topic> getAllTopic();
        public Topic get(int id);
}
