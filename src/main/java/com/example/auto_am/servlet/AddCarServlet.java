package com.example.auto_am.servlet;

import com.example.auto_am.manager.CarManager;
import com.example.auto_am.model.Car;
import com.example.auto_am.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/addCar")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AddCarServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "C:\\Users\\Admin\\Desktop\\Java\\ItSpaceLessons\\auto_am\\uploaded_images";

    private CarManager carManager = new CarManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        Part filePart = req.getPart("picture");
        String fileName = filePart.getSubmittedFileName();
        String picUrl = System.currentTimeMillis() + "_" + fileName;
        filePart.write(UPLOAD_DIR + picUrl);

        String make = req.getParameter("make");
        String model = req.getParameter("model");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Car car = Car.builder()
                .user(user)
                .make(make)
                .model(model)
                .price(price)
                .description(description)
                .picUrl(picUrl)
                .createdDate(new Date())
                .build();

        carManager.addCar(car);
        req.getSession().setAttribute("msg", "car was added");
        resp.sendRedirect("/addCar");

    }
}
