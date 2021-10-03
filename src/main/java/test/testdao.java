package test;

import dao.LoginDao;
import dao.dao;
import entity.Person;

public class testdao {

	public static void main(String[] args) {
		LoginDao dao = new LoginDao();
		Person person = dao.LoginCheck("emo", "test1");
		System.out.println(person.getId());
		
	}
}
