package com.victorwangzhen.coolapp.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTTokenUtil {

    private static final String AUTHORITIES_KEY = "ZHEN";

    private String secretKey;

    private long tokenValidityInMilliseconds;

    private long longTokenValidityInMilliseconds;

    @PostConstruct
    public void init(){
        this.secretKey = "ZhenWang";
        int secondInOneDay = 1000 * 60*60*24;
        this.tokenValidityInMilliseconds = secondInOneDay * 2L;
        this.longTokenValidityInMilliseconds = secondInOneDay *7L;
    }


    public String createToken(Authentication authentication, Boolean rememberMe){

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority:: getAuthority)
                .collect(Collectors.joining(","));

        Date validaty;

        long presentTime = (new Date()).getTime();
        if(rememberMe){
            validaty = new Date( presentTime + longTokenValidityInMilliseconds) ;
        }
        else {
            validaty = new Date( presentTime + tokenValidityInMilliseconds );
        }

        return Jwts.builder()
                .claim(AUTHORITIES_KEY, authorities)
                .setSubject(authentication.getName())           //设置面向用户//添加权限属性
                .setExpiration(validaty)                        //设置失效时间
                .signWith(SignatureAlgorithm.HS512,secretKey)   //生成签名
                .compact();
    }

    public Authentication getAuthentication(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        List<GrantedAuthority> grantedAuthorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(claims.getSubject(), "", grantedAuthorities);
    }
}
