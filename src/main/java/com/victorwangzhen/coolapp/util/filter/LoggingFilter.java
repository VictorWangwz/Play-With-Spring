package com.victorwangzhen.coolapp.util.filter;


import javax.servlet.*;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        System.out.println("prefilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("postfilter");


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("prefilter");

    }

    @Override
    public void destroy() {

        System.out.println("destoryfilter");

    }
}
