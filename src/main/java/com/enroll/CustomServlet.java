package com.enroll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  12:51 2018/9/17
 * @ModefiedBy:
 */
@WebServlet
public class CustomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "xiao hei");
//        request.getRequestDispatcher("jsps/main.jsp").forward(request, response);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "fusong");
        map.put("age", 20);
        map.put("gender", "male");
        request.getSession().setAttribute("map", map);
        response.sendRedirect("jsps/main.jsp");
    }
}
