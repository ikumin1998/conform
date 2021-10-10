package entity;

import java.sql.Timestamp;

public class BoardInside {

	private int id;
	private int createdId;
	private int boardid;
	private String name;// 掲示板に投稿した名前のこと
	private String msg;// 掲示板へ投稿したメッセージ
	private Timestamp time;// 掲示板へ作成した時間

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedId() {
		return createdId;
	}

	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
}
