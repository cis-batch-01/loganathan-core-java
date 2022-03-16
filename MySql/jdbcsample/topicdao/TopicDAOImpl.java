package com.topicdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcsampletopic.Topic;

public class TopicDAOImpl implements TopicDAO {
	static String selectAllTopic="select topic_id,topic_name,description,content,created_date,updated_date from topic";
	static String selectTopic="select topic_id,topic_name,description,content,created_date,updated_date from topic where topic_id=?";
	static String insertTopic="insert into topic (topic_name,description,content,created_date,updated_date) values(?,?,?,?,?)";
	static String updateTopic="update topic set  topic_name=?,description=?,content=?,created_date=?,updated_date=? where topic_id=?";
	static String deleteTopic="DELETE FROM topic  WHERE topic_id=?";
	
	public Topic getTopic(int id) {
		Topic topic=null;
		Connection con=ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(selectTopic );
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery(); //select query
			if(rs.next())
			{
			 topic =new Topic (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5),rs.getDate(6));//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return topic;
		
	}

	public List<Topic> getAllTopic() {
		List<Topic> resList=new ArrayList();
		Connection con=ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(selectAllTopic);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
			resList.add(new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getDate(5),rs.getDate(6)));//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resList;
	}
		
	

	public Topic saveTopic(Topic topic) {
		Connection con=ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(insertTopic);
			pstmt.setString(1, topic.getTopicName());
			pstmt.setString(2,topic.getDescription());
			pstmt.setString(3,topic.getContent());
			pstmt.setDate(4,new java.sql.Date(topic.getCreateDate().getTime()));// 12-12-2020    2020-12-12
 			pstmt.setDate(5,new java.sql.Date(topic.getLastModifiedDate().getTime()));
			int res=pstmt.executeUpdate();
			if(res>0)
			{
				return topic;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
		
	

	public Topic updateTopic(int id, Topic topic) {
		Connection con=ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(updateTopic);
			pstmt.setString(1, topic.getTopicName());
			pstmt.setString(2,topic.getDescription());
			pstmt.setString(3,topic.getContent());
			pstmt.setDate(4,new java.sql.Date(topic.getCreateDate().getTime())); 
 			pstmt.setDate(5,new java.sql.Date(topic.getLastModifiedDate().getTime()));
			pstmt.setInt(6, id);
			int res=pstmt.executeUpdate();
			if(res>0)
			{
				return topic;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		

	public Topic deleteTopic(int id) {
		Connection con=ConnectionUtil.getDBConnect();
		Topic topic=getTopic(id);
		try {
			PreparedStatement pstmt=con.prepareStatement(deleteTopic);
			pstmt.setInt(1, id);
			int res=pstmt.executeUpdate();
			if(res>0) {
				return topic;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
