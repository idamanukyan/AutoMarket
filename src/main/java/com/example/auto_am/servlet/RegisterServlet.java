package com.example.auto_am.servlet;

import com.example.auto_am.manager.UserManager;
import com.example.auto_am.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");

        if (!password.equals(rePassword)) {
            req.getSession().setAttribute("msg", "Passwords do not match");
            resp.sendRedirect("/");
        } else {
            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .build();
            userManager.addUser(user);

            req.getSession().setAttribute("msg", "User was registered successfully");
            resp.sendRedirect("/");
        }
    }
}
