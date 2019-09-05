package com.victorwangzhen.coolapp.util.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends BasicAuthenticationFilter {


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        String authentication = request.getHeader("Authentication");
        if(authentication == null || !authentication.startsWith("token")){
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken token = getAuthentication(authentication);

        //todo what does holder do?
        SecurityContextHolder.getContext().setAuthentication(token);

        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String authentication){

        Claims claim = Jwts.parser().parseClaimsJws(authentication.replace("token ", "")).getBody();
        String username = claim.getAudience();
        if(username == null){
            return null;
        }
        return new UsernamePasswordAuthenticationToken(username, null);

    }
}
