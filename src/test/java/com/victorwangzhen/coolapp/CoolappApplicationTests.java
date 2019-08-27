package com.victorwangzhen.coolapp;

import com.victorwangzhen.coolapp.model.dao.UserDao;
import com.victorwangzhen.coolapp.model.entity.User;
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


		User user1 = userDao.findAll().get(0);

		System.out.println(user1);

	}

}
