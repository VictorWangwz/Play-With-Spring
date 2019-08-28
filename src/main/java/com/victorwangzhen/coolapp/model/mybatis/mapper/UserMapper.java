package com.victorwangzhen.coolapp.model.mybatis.mapper;


import com.victorwangzhen.coolapp.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    Integer insert(User user);


    List<User> getAll();

}
