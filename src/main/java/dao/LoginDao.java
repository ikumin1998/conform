package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Person;

public class LoginDao {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql:rundb";
	private static final String USER = "postgres";
	private static final String PASSWORD = "test";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

	public Person LoginCheck(String name, String pass) {
		String sql = "SELECT * FROM personinfo JOIN login ON personinfo.username = login.name WHERE login.name = ? AND login.pass=?";
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("personid"));
				person.setUserName(rs.getString("username"));
				person.setPassword(rs.getString("pass"));
				return person;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * //一発で複数のテーブルを更新する方法 public int AddPerson(Person person) { int result = -1;
	 * String sql =
	 * "WITH add As(insert into login1(name,pass) values(?,?) returning ?,?,?,?,?,?) insert into person1(user_name,age,place,ftp,howlong,comment) select  * from add"
	 * ; try(Connection con = getConnection(); PreparedStatement pstmt =
	 * con.prepareStatement(sql)){ pstmt.setString(1, person.getName());
	 * pstmt.setString(2, person.getPassword()); pstmt.setString(3,
	 * person.getUserName()); pstmt.setString(4, person.getAge());
	 * pstmt.setString(5, person.getPlace()); pstmt.setString(6, person.getFTP());
	 * pstmt.setString(7, person.getHowlong()); pstmt.setString(8,
	 * person.getComment()); result = pstmt.executeUpdate(); }catch(SQLException |
	 * ClassNotFoundException e) { e.printStackTrace(); } return result; }
	 */
	public int AddLogin1(String name, String pass) {
		int result = -1;
		String sql = "INSERT INTO login (name,pass) VALUES(?,?)";
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			result = pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int AddPerson(Person person) {
		int result = -1;
		String sql = "INSERT INTO personinfo (username,age,place,ftp,howlong,commentp) VALUES(?,?,?,?,?,?)";
		try (Connection con = getConnection(); PreparedStatement p = con.prepareStatement(sql)) {
			p.setString(1, person.getUserName());
			p.setInt(2, person.getAge());
			p.setString(3, person.getPlace());
			p.setInt(4, person.getFTP());
			p.setInt(5, person.getHowlong());
			p.setString(6, person.getComment());
			result = p.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Person PersonInfo(int id) {
		String sql = "SELECT * FROM personinfo WHERE id = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("personid"));
				p.setUserName(rs.getString("username"));
				return p;

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
