package entity;

public class Person {
	private int Id;// personidのこと
	private String UserName;
	private String Password;
	private int Age;
	private String place;
	private int FTP;
	private int howlong;
	private String comment;

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getFTP() {
		return FTP;
	}

	public void setFTP(int fTP) {
		FTP = fTP;
	}

	public int getHowlong() {
		return howlong;
	}

	public void setHowlong(int howlong) {
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
	}

}
