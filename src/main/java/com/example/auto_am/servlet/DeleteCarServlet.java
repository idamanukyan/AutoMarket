package com.example.auto_am.servlet;


import com.example.auto_am.manager.CarManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteCar")
public class DeleteCarServlet extends HttpServlet {

    private CarManager carManager = new CarManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("id"));
        carManager.deleteCar(carId);
        req.getSession().setAttribute("msg", "car was removed");
        resp.sendRedirect("/home");
    }
}
