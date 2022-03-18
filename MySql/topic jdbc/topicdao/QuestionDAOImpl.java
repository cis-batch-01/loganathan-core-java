package com.topicdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.topicmodel.Question;
import com.topicmodel.Topic;

public class QuestionDAOImpl implements QuestionDAO {

	static String selectQuestion="select question_content,topic_name from question where question_id=?";
	static String selectAllQuestion="select question_id,question_content,topic_name  from question ";
	static String addQuestion=    "insert into question(question_content,topic_name) values(?,?)";
	static String updateQuestion="update question set question_content=?,topic_name=?  where question_id=?";
	static String deleteQuestion="delete from question where question_id=? ";
	public Question getQuestion(int id) {
		Connection con=ConnectionUtil.getDBconnect();
		   
		   PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(selectQuestion);
			 pstmt.setInt(1,id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					return getQuestion(1);
					}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
			
		   return null;
	}
		
	public List<Question> getAllQuestion() {
		List<Question> resList=null;
		Connection con=ConnectionUtil.getDBconnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(selectAllQuestion);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				
				 resList.add(new Question (rs.getInt(1),rs.getString(2),rs.getString(3)));
		} 
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public Question addTopic(Question question) {
		Connection con=ConnectionUtil.getDBconnect();
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(addQuestion);
			 pstmt.setString(1,question.getQuestion_content());
				pstmt.setString(2,question.getTopic_name());
				int rs =pstmt.executeUpdate();
				if(rs>0){
					return question;
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public Question updateQuestion(int id, Question question) {
	Connection con=ConnectionUtil.getDBconnect();
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(updateQuestion);
			 pstmt.setString(1,question.getQuestion_content());
				pstmt.setString(2,question.getTopic_name());
				pstmt.setInt(3, id);
				int rs =pstmt.executeUpdate();
				if(rs>0){
					return question;
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	
	}
	public Question deleteQuestion(int id) {
		Connection con=ConnectionUtil.getDBconnect();
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(deleteQuestion);
			pstmt.setInt(1,id);
			int rs =pstmt.executeUpdate();
			if(rs>0){
				return getQuestion(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
}
