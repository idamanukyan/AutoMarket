package com.example.auto_am.servlet;


import com.example.auto_am.manager.CarManager;
import com.example.auto_am.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateCar")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UpdateCarServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "C:\\Users\\Admin\\Desktop\\Java\\ItSpaceLessons\\auto_am\\uploaded_images";

    private CarManager carManager = new CarManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("id"));
        Car car = carManager.getCarById(carId);
        req.setAttribute("car", car);
        req.getRequestDispatcher("/WEB-INF/updateCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("id"));
        Car carById = carManager.getCarById(carId);
        if (carById != null) {

            Part filePart = req.getPart("picture");
            String fileName = filePart.getSubmittedFileName();
            String picUrl = System.currentTimeMillis() + "_" + fileName;
            filePart.write(UPLOAD_DIR + picUrl);

            String make = req.getParameter("make");
            String model = req.getParameter("model");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");

            Car car = Car.builder()
                    .id(carId)
                    .make(make)
                    .model(model)
                    .price(price)
                    .description(description)
                    .picUrl(picUrl)
                    .build();
            carManager.updateCar(car);
            req.getSession().setAttribute("msg", "car was updated");
            resp.sendRedirect("/home");
        }

    }
}
