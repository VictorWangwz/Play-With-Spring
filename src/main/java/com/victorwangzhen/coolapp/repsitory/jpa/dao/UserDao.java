package com.victorwangzhen.coolapp.repsitory.jpa.dao;


import com.victorwangzhen.coolapp.repsitory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query("select user from User user where user.username = ?1")
    public List<User> findByUsername(String username);
}
