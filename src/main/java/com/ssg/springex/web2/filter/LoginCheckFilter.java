package com.ssg.springex.web2.filter;

import jakarta.servlet.annotation.WebFilter;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/web2/*"})
@Log4j2
public class LoginCheckFilter implements Filter{

    //Filter 인터페이스 => implements로 구현
    //doFilter 추상 메소드 : 필터링이 필요한 로직을 구현하는 메소드

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //순수 서블릿 객체 : ServletRequest, ServletResponse
        //@WebFilter(urlPatterns = {"/web2/*"}) <- 해당 경로의 요청에 대해 doFilter를 실행. /web2/로 시작하는 모든 경로에 대해 필터링을 시도

        log.info("LoginCheck Filter 실행!");

        HttpServletRequest request = (HttpServletRequest) servletRequest; //다운캐스팅
        HttpServletResponse response = (HttpServletResponse) servletResponse; //다운캐스팅

        HttpSession session = request.getSession();

        //세션의 값이 없다면
        if(session.getAttribute("loginInfo") == null) {
            response.sendRedirect("/web2/login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);


    }
}
