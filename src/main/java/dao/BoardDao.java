package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Board;

public class BoardDao {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql:postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "test";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

	public static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	public int Addboard(String time, String place, String comment, int id) {
		int result = -1;
		String sql = "INSERT INTO board_detail(time,place,comment,member_id,createdtime)VALUES(?,?,?,?,?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, time);
			ps.setString(2, place);
			ps.setString(3, comment);
			ps.setInt(4, id);
			ps.setTimestamp(5, getCurrentTimeStamp());
			result = ps.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Board> AllSerch() {
		List<Board> list = new ArrayList<Board>();
		String sql = "SELECT * FROM board_detail JOIN person1 ON board_detail.member_id = person1.id";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Board b = new Board();
				b.setTime(rs.getString("time"));
				b.setPlace(rs.getString("board_place"));
				b.setComment(rs.getString("board_comment"));
				b.setName(rs.getString("user_name"));
				b.setId(rs.getInt("board_id"));
				list.add(b);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Board SeeBoard(int memberId) {
		String sql = "SELECT  * FROM board_detail JOIN person1 ON board_detail.member_id = person1.id WHERE board_id = ?";
	try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
		ps.setInt(1,memberId);
		ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Board b = new Board();
				b.setId(rs.getInt("board_id"));
				b.setComment(rs.getString("board_comment"));
				b.setPlace(rs.getString("board_place"));
				b.setTime(rs.getString("time"));
				b.setName(rs.getString("user_name"));
				b.setAge(rs.getString("age"));
				b.setFtp(rs.getString("ftp"));
				b.setHowlong(rs.getString("howlong"));
				return b;
			}
		
	}catch(SQLException|ClassNotFoundException e) {
		e.printStackTrace();
	}
	return null;
	}
}
