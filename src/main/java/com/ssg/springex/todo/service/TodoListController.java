package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dto.TodoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "todoListControlller", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet { //웹 클래스이므로 http servlet 상속 받음

    //Get 만 사용하므로, doGet만 필요
    //@Webservlet으로 웹 클래스인것을 알리고, 이름을 todo로 한다


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list----------call------------");

        //리스트 객체를 list.jsp 화면에 출력해주기 위해서 req에 setAttribute를 통해서 객체를 담아 전달한다
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        req.setAttribute("dtoList", dtoList);
        req.getRequestDispatcher("/todo/list.jsp").forward(req,resp); //원하는 위치의 페이지를 부른다. list.jsp로 이동해. 근데 req, resp를 가지고 이동해.
    }
}
