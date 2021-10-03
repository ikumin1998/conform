package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Person;

public class dao {

	private static final String URL = "jdbc:postgresql:postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "test";

	public Person LoginCheck(String name, String pass) {
		String sql = "SELECT * FROM person JOIN login1 ON person.user_name = login.name WHERE login.name = ? login.pass=?";
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setUserName(rs.getString("user_name"));
				person.setPassword(rs.getString("pass"));
				return person;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
