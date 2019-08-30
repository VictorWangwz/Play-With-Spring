package com.victorwangzhen.coolapp.service;

import com.victorwangzhen.coolapp.repsitory.entity.User;
import com.victorwangzhen.coolapp.repsitory.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = userDao.findByUsername(s);
        if(users == null || users.size() != 1){
            throw new UsernameNotFoundException("not found");
        }
        User user = users.get(0);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user)
        );

    }

    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> grantedAuthorities = user
                .getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return grantedAuthorities;


    }
}
