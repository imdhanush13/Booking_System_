package com.salonbooking.controller;

import com.salonbooking.model.Appointment;
import com.salonbooking.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public Appointment book(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
