package com.victorwangzhen.coolapp;

import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
import com.victorwangzhen.coolapp.repsitory.jpa.dao.UserDao;
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
		UserEntity userEntity = new UserEntity();
		userEntity.setId("test");
		userEntity.setPassword("pwd");
		userEntity.setUsername("name");

		Object rst = userDao.save(userEntity);
		System.out.println(rst);

	}


}
