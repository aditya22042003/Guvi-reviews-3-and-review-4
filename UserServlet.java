package com.healthcare.controllers;

import com.healthcare.dao.UserDAO;
import com.healthcare.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("profile".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("user") != null) {
                request.getRequestDispatcher("WEB-INF/views/profile.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User(name, email, password);
            boolean success = userDAO.registerUser(user);

            if (success) {
                response.sendRedirect("index.jsp?success=1");
            } else {
                response.sendRedirect("index.jsp?error=1");
            }
        }
    }
}
