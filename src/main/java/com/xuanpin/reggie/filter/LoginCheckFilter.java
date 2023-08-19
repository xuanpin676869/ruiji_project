package com.xuanpin.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.xuanpin.reggie.common.BaseContext;
import com.xuanpin.reggie.common.R;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //路径匹配器，支持通配符
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",
                "/user/login"
        };
        //判断本次请求是否需要处理
        boolean check = check(urls,requestURI);
        if(check){
            //在数组中的放行
            filterChain.doFilter(request,response);
            return;
        }
        //后台管理登录判断
        if(request.getSession().getAttribute("employee") != null){
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            //已登录的放行
            filterChain.doFilter(request,response);
            return;
        }
        //手机用户登录判断
        if(request.getSession().getAttribute("user") != null){
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            //已登录的放行
            filterChain.doFilter(request,response);
            return;
        }
        //如果未返回登录结果，通过输出流的方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }


    public boolean check(String[] urls,String requestURL) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url,requestURL);
            if (match){
                return true;
            }
        }
        return false;
    }
}
