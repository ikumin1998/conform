package test;

import dao.dao;
import entity.Person;

public class testdao {

	public void testLoginCheck() {
		dao dao = new dao();
		Person person = dao.LoginCheck("emo", "test1");
		System.out.println(person.getId());
		
	}
}
