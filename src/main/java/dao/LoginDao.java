package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Person;

public class LoginDao {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql:postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "test";
	private Connection getConnection() 
			throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		return con;
	}
	
	public Person LoginCheck(String name, String pass)  {
		String sql = "SELECT * FROM person JOIN login1 ON person.user_name = login1.name WHERE login1.name = ? AND login1.pass=?";
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setUserName(rs.getString("user_name"));
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("pass"));
				return person;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
