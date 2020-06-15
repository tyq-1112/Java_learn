package com.controller;

import com.Dao.UserDao;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        int result = 0;
        PrintWriter out = null;
        //通过请求对象获取【请求头】中的信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //调用Dao保存到MySQL数据库
        User user = new User(null, userName, password, sex, email);
        try {
            result = UserDao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //调用【响应对象】将处理结果以二进制形式写入响应体
        response.setCharacterEncoding("utf-8");
        out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");

        System.out.println(result);
        if (result == 1) {
            out.print("<font style='color: red;font-size: 40px'>用户信息注册成功</font>");
        } else out.print("<font style='color: red;font-size: 40px'>用户信息注册失败</font>");
    }
}
