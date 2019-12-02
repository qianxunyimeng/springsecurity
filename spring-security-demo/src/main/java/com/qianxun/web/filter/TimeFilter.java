package com.qianxun.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-11-27 22:25
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init.......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start....");
        long start = new Date().getTime();
        filterChain.doFilter(request,response);
        long end = new Date().getTime();
        System.out.println("time filter耗时: "+(end - start));
        System.out.println("time filter end....");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy........");
    }
}
