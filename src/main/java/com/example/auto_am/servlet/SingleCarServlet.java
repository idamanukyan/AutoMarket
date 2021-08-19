package com.example.auto_am.servlet;


import com.example.auto_am.manager.CarManager;
import com.example.auto_am.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/singleCar")
public class SingleCarServlet extends HttpServlet {

    private CarManager carManager = new CarManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Car car = carManager.getCarById(id);

        req.setAttribute("car", car);
        req.getRequestDispatcher("/WEB-INF/singleCar.jsp").forward(req, resp);
    }
}
