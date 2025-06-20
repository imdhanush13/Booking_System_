package com.salonbooking.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private LocalDate availableDate;

    private LocalTime availableTime;


    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public double getPrice() {

        return price;
    }
    public void setPrice(double price) {

        this.price = price;
    }
    public LocalDate getAvailableDate() {

        return availableDate;
    }
    public void setAvailableDate(LocalDate availableDate) {

        this.availableDate = availableDate;
    }
    public LocalTime getAvailableTime() {
        return availableTime;
    }
    public void setAvailableTime(LocalTime availableTime) {
        this.availableTime = availableTime;
    }

}
