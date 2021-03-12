package com.web.servlet;

import com.domain.PageBean;
import com.domain.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }


        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        Map<String, String[]> condition = request.getParameterMap();
        UserServiceImpl service = new UserServiceImpl();
        PageBean<User> pb =service.fingUserPage(currentPage,rows,condition);
        System.out.println(pb);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }
}
