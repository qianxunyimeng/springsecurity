/**
 * 
 */
package com.qianxun.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {

	//进入controller方法之前调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod)handler).getMethod().getName());
		
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}
    //controller方法成功执行结束后调用，一旦抛出异常，就不会调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));

	}
	//controller方法结束调用，成功与否都会执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));
		System.out.println("ex is "+ex);

	}

}
