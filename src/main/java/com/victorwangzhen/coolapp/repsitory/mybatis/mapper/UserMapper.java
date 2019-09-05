package com.victorwangzhen.coolapp.repsitory.mybatis.mapper;


import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    Integer insert(UserEntity userEntity);


    List<UserEntity> getAll();

}
