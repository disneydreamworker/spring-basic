package com.ssg.springex.web2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/web2/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/web2/login.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //파라미터 수집
        String mid = req.getParameter("mid");
        String mpwd = req.getParameter("mpwd");

        //문자열 합산
        String str = mid + mpwd;

        //사용자에게 부여된 세션아이디를 가져오고 해당 세션 객체에 로그인 정보를 저장
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", str);
        resp.sendRedirect("/web2/list");

        //사용자의 공간에 loginInfo 속성이 생기며 로그인 문자열이 보관됨
    }
}
