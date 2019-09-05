package com.victorwangzhen.coolapp.service;

import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
import com.victorwangzhen.coolapp.repsitory.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserEntity> userEntities = userDao.findByUsername(s);
        if(userEntities == null || userEntities.size() != 1){
            throw new UsernameNotFoundException("not found");
        }
        UserEntity userEntity = userEntities.get(0);

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                getAuthorities(userEntity)
        );

    }

    private List<GrantedAuthority> getAuthorities(UserEntity userEntity){
        List<GrantedAuthority> grantedAuthorities = userEntity
                .getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return grantedAuthorities;


    }
}
