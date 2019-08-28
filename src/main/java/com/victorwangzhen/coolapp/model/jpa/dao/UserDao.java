package com.victorwangzhen.coolapp.model.jpa.dao;


import com.victorwangzhen.coolapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
