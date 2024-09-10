package com.ssg.springex.web2.controller;

import com.ssg.springex.web2.dto.MemberDTO;
import com.ssg.springex.web2.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String mpw = req.getParameter("mpwd");

        //문자열 합산
        String str = mid + mpw;

        try {

            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            //사용자에게 부여된 세션아이디를 가져오고 해당 세션 객체에 로그인 정보를 저장
            HttpSession session = req.getSession();
            //사용자의 공간에 loginInfo 속성이 생기며 로그인 객체가 보관됨
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/web2/list");
        } catch (Exception e) {
            //예외 발생 시 result=error 파라미터를 전달하여 에러 발생 전달
            resp.sendRedirect("/web2/login?result=error");
        }
    }
}
