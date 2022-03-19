package com.topicdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.topicmodel.Topic;

public class TopicDAOImpl implements TopicDAO {
	static String selectTopic = "select topic_name,description,content,date from topic where topic_id=?";
	static String selectAllTopic = "select topic_id,topic_name,description,content,date from topic ";
	static String addTopic = "insert into topic (topic_name,description,content,date)values(?,?,?,?)";
	static String updateTopic = "update topic set topic_name=?,description=?,content=?,date=?  where topic_id=?";
	static String deleteTopic = "delete from topic where topic_id=? ";

	public Topic getTopic(int id) {
		Connection con = ConnectionUtil.getDBconnect();
		Topic topic = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(selectTopic);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				topic = new Topic(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return topic;
	}

	public List<Topic> getAllTopic() {
		List<Topic> topicList = new ArrayList<Topic>();
		Connection con = ConnectionUtil.getDBconnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(selectAllTopic);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				topicList
						.add(new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
					con.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return topicList;
	}

	public Topic addTopic(Topic topic) {
		Connection con = ConnectionUtil.getDBconnect();

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(addTopic);
			pstmt.setString(1, topic.getTopic_Name());
			pstmt.setString(2, topic.getDescription());
			pstmt.setString(3, topic.getContent());
			pstmt.setDate(4, new java.sql.Date(topic.getDate().getTime()));
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return topic;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return null;
	}

	public Topic updateTopic(int id, Topic topic) {
		Connection con = ConnectionUtil.getDBconnect();

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(updateTopic);
			pstmt.setString(1, topic.getTopic_Name());
			pstmt.setString(2, topic.getDescription());
			pstmt.setString(3, topic.getContent());
			pstmt.setDate(4, new java.sql.Date(topic.getDate().getTime()));
			pstmt.setInt(5, id);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return topic;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return null;
	}

	public Topic deleteTopic(int id) {
		Connection con = ConnectionUtil.getDBconnect();
		Topic topic = getTopic(id);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(deleteTopic);
			pstmt.setInt(1, id);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return topic;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return null;
	}

}
