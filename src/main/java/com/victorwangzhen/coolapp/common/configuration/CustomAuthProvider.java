package com.victorwangzhen.coolapp.common.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder;

    public CustomAuthProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        String dbPassword = userDetailsService.loadUserByUsername(username).getPassword();

        if(password.equals(dbPassword)){
            return new UsernamePasswordAuthenticationToken(username, password);
        }

        throw new UsernameNotFoundException("password mismatched");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals((UsernamePasswordAuthenticationToken.class));
    }
}
