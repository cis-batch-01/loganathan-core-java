package com.topicdao;

import java.util.List;

import com.topicmodel.Question;

public interface QuestionDAO {
	public Question getQuestion(int id);
	public List<Question> getAllQuestion();
	public Question addTopic(Question question);
	public Question updateQuestion(int id,Question question);
	public Question deleteQuestion(int id);
}
