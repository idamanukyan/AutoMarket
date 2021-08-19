package com.example.auto_am.servlet;

import com.example.auto_am.manager.CarManager;
import com.example.auto_am.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cars")
public class GetCarsServlet extends HttpServlet {

    private CarManager carManager = new CarManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carManager.getCars();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/cars.jsp").forward(req, resp);
    }
}