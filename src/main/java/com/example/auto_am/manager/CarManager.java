package com.example.auto_am.manager;

import com.example.auto_am.db.DBConnectionProvider;
import com.example.auto_am.model.Car;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CarManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();
    private UserManager userManager = new UserManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void addCar(Car car) {
        try {
            String query = "INSERT INTO `car` (`owner_id`,`make`,`model`,`price`,`description`, `pic_url`, `created_date`) " +
                    "VALUES(?,?,?,?,?,?,?);";

            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pStatement.setInt(1, car.getUser().getId());
            pStatement.setString(2, car.getMake());
            pStatement.setString(3, car.getModel());
            pStatement.setDouble(4, car.getPrice());
            pStatement.setString(5, car.getDescription());
            pStatement.setString(6, car.getPicUrl());
            pStatement.setString(7, sdf.format(car.getCreatedDate()));

            //System.out.println(query);

            pStatement.executeUpdate();

            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                car.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE car SET make = '%s', model = '%s', price ='%s', description='%s', pic_url='%s' WHERE id=" + car.getId(),
                    car.getMake(), car.getModel(), car.getPrice(), car.getDescription(), car.getPicUrl());

            statement.executeUpdate(query);

        } catch (SQLException е) {
            е.printStackTrace();
        }
    }

    public List<Car> getCars() {
        String sql = "SELECT * from car";
        List<Car> result = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Car car = Car.builder()
                        .id(resultSet.getInt(1))
                        .user(userManager.getUserById(resultSet.getInt(2)))
                        .make(resultSet.getString(3))
                        .model(resultSet.getString(4))
                        .price(resultSet.getDouble(5))
                        .description(resultSet.getString(6))
                        .picUrl(resultSet.getString(7))
                        .createdDate(resultSet.getDate(8))
                        .build();
                result.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Car getCarById(int id) {
        String sql = "SELECT * FROM car WHERE id=" + id;

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return Car.builder()
                        .id(resultSet.getInt(1))
                        .user(userManager.getUserById(resultSet.getInt(2)))
                        .make(resultSet.getString(3))
                        .model(resultSet.getString(4))
                        .price(resultSet.getDouble(5))
                        .description(resultSet.getString(6))
                        .picUrl(resultSet.getString(7))
                        .createdDate(resultSet.getDate(8))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCar(int id) {
        String sql = "DELETE from car where id = " + id;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
