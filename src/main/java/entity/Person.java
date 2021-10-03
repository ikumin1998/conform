package entity;

public class Person {
	private int Id;
	private String UserName;//person1に入れるよう
	private String Name;//login1に入れる
	private String Password;
	private String Age;
	private String place;
	private String FTP;
	private String howlong;
	private String comment;
	
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getFTP() {
		return FTP;
	}
	public void setFTP(String fTP) {
		FTP = fTP;
	}
	public String getHowlong() {
		return howlong;
	}
	public void setHowlong(String howlong) {
		this.howlong = howlong;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
