package com.victorwangzhen.coolapp.common.configuration;

import com.victorwangzhen.coolapp.util.filter.JwtLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class FilterConfiguration {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new JwtLoggingFilter(authenticationManager));

        registrationBean.setName("JwtLoggingFilter");

        registrationBean.addUrlPatterns("/*");

        registrationBean.setOrder(1);

        return registrationBean;
    }
}
