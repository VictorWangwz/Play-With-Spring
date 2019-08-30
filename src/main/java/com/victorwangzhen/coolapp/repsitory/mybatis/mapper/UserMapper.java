package com.victorwangzhen.coolapp.repsitory.mybatis.mapper;


import com.victorwangzhen.coolapp.repsitory.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    Integer insert(User user);


    List<User> getAll();

}
