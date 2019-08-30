package com.victorwangzhen.coolapp;

import com.victorwangzhen.coolapp.repsitory.jpa.dao.UserDao;
import com.victorwangzhen.coolapp.repsitory.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoolappApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void test001_jpaTest() {
		User user = new User();
		user.setId("test");
		user.setPassword("pwd");
		user.setUsername("name");

		Object rst = userDao.save(user);
		System.out.println(rst);

	}


}
