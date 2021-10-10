package entity;

import java.sql.Timestamp;

public class BoardInside {

private int id;
private int createdId;
private String name;
private String msg;
private Timestamp time;
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
}
