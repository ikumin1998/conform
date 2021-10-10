package entity;

public class Board {
	private int id;// serial の id
	private int memberId;// personidのこと
	private int boardid;// 引数で入力するboardid
	private String time;
	private String place;
	private String comment;// boarddeのコメントのこと
	private String name;// usernameのこと
	private int ftp;
	private int age;
	private int howlong;
	private java.sql.Timestamp createtime;

	public java.sql.Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.sql.Timestamp timestamp) {
		this.createtime = timestamp;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public int getHowlong() {
		return howlong;
	}

	public void setHowlong(int howlong) {
		this.howlong = howlong;
	}

	public int getFtp() {
		return ftp;
	}

	public void setFtp(int ftp) {
		this.ftp = ftp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
