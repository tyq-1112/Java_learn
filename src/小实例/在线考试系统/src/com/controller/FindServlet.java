package com.controller;

import com.Dao.UserDao;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class FindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到数据库中所有用户的信息
        List<User> userList = UserDao.find();
        PrintWriter out = null;
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr align = 'center'>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
        for (User user : userList) {
            out.print("<tr>");
            out.print("<td>" + user.getUser_Id() + "</td>");
            out.print("<td>" + user.getUserName() + "</td>");
            out.print("<td>" + "*******" + "</td>");
            out.print("<td>" + user.getSex() + "</td>");
            out.print("<td>" + user.getEmail() + "</td>");
            out.print("<td><a href='del?userId=" + user.getUser_Id() + "'>删除</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
