package com.ssg.springex.web2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet("/logout")
@Log4j2
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //logout
        log.info("log out !");

        //세션을 삭제한다
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo"); //세션 객체에 저장되어 있는 속성 loginInfo를 삭제
        session.invalidate(); //세션 종료 메소드

        resp.sendRedirect("/");
    }
}
