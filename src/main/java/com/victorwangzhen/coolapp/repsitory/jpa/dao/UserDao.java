package com.victorwangzhen.coolapp.repsitory.jpa.dao;


import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {

    @Query("select user from UserEntity user where user.username = ?1")
    public List<UserEntity> findByUsername(String username);
}
