package com.victorwangzhen.coolapp;

import com.victorwangzhen.coolapp.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.victorwangzhen.coolapp.model"})
@MapperScan("com.victorwangzhen.coolapp.model.mybatis.mapper")
public class CoolappApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CoolappApplication.class, args);

		SpringContextUtil.setApplicationContext(applicationContext);
	}

}
