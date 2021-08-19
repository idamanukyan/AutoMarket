package com.example.auto_am.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private int id;
    private User user;
    private String make;
    private String model;
    private Double price;
    private String description;
    private String picUrl;
    private Date createdDate;

}
