package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Board;
import entity.BoardInside;

public class BoardDao {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql:rundb";
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

	public int Addboard(int boardid, String time, String place, String comment, int id) {
		int result = -1;
		String sql = "INSERT INTO boardde(boardid,time,placebd,commentbd,personid,createtime)VALUES(?,?,?,?,?,?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, boardid);
			ps.setString(2, time);
			ps.setString(3, place);
			ps.setString(4, comment);
			ps.setInt(5, id);
			ps.setTimestamp(6, getCurrentTimeStamp());
			result = ps.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Board> AllSerch() {
		List<Board> list = new ArrayList<Board>();
		String sql = "SELECT * FROM boardde JOIN personinfo ON boardde.personid = personinfo.personid";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Board b = new Board();
				b.setBoardid(rs.getInt("boardid"));
				b.setTime(rs.getString("time"));
				b.setPlace(rs.getString("placebd"));
				b.setComment(rs.getString("commentbd"));
				b.setName(rs.getString("username"));
				b.setId(rs.getInt("boardid"));
				b.setCreatetime(rs.getTimestamp("createtime"));
				list.add(b);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Board SeeBoard(int memberId) {
		String sql = "SELECT  * FROM boardde JOIN personinfo ON boardde.personid = personinfo.personid WHERE boardde.boardid = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, memberId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Board b = new Board();
				b.setBoardid(rs.getInt("boardid"));
				b.setComment(rs.getString("commentbd"));
				b.setPlace(rs.getString("placebd"));
				b.setTime(rs.getString("time"));
				b.setName(rs.getString("username"));
				b.setAge(rs.getInt("age"));
				b.setFtp(rs.getInt("ftp"));
				b.setHowlong(rs.getInt("howlong"));
				return b;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<BoardInside> SerachBoard(int boardid) {
		ArrayList<BoardInside> list = new ArrayList<BoardInside>();
		String sql = "SELECT * FROM boardmsg WHERE boardid = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, boardid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				BoardInside b = new BoardInside();
				b.setBoardid(rs.getInt("boardid"));
				b.setName(rs.getString("name"));
				b.setMsg(rs.getString("msg"));
				b.setTime(getCurrentTimeStamp());
				list.add(b);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int CountDB() {
		int result = 0;
		String sql = "SELECT  COUNT(*) from boardde";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int AddInside(int boardid) {
		int result = -1;
		String sql = "INSERT INTO boardmsg(boardid)VALUES(?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, boardid);
			result = ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int CountBoardde() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM boardde";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}
}
