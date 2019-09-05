package com.victorwangzhen.coolapp.common.configuration;

import com.victorwangzhen.coolapp.service.UserService;
import com.victorwangzhen.coolapp.util.filter.JwtAuthenticationFilter;
import com.victorwangzhen.coolapp.util.filter.JwtLoggingFilter;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserService userService;

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();

    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.authenticationProvider(
                new CustomAuthProvider(
                        userService,
                        new PasswordEncoder() {
                            @Override
                            public String encode(CharSequence charSequence) {
                                return charSequence.toString();
                            }

                            @Override
                            public boolean matches(CharSequence charSequence, String s) {
                                return charSequence.toString().equals(s);
                            }
                        }));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/save").permitAll()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()

                .and().sessionManagement().maximumSessions(1)
                .sessionRegistry(sessionRegistry)

                .and().and()
                .addFilter(new JwtLoggingFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.csrf().disable();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }


}
