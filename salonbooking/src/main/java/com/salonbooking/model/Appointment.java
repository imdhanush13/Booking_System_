package com.salonbooking.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String contact;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private LocalDate bookedDate;

    private LocalTime bookedTime;


    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contactInfo) {
        this.contact = contactInfo;
    }
    public LocalDate getBookedDate() {
        return bookedDate;
    }
    public void setBookedDate(LocalDate bookedDate) {
        this.bookedDate = bookedDate;
    }
    public LocalTime getBookedTime() {
        return bookedTime;
    }
    public void setBookedTime(LocalTime bookedTime) {
        this.bookedTime = bookedTime;
    }
    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }

}
