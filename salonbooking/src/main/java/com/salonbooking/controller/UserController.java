package com.salonbooking.controller;

import com.salonbooking.model.Appointment;
import com.salonbooking.model.Service;
import com.salonbooking.repository.AppointmentRepository;
import com.salonbooking.repository.ServiceRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final ServiceRepository serviceRepo;
    private final AppointmentRepository appointmentRepo;

    public UserController(ServiceRepository serviceRepo, AppointmentRepository appointmentRepo) {
        this.serviceRepo = serviceRepo;
        this.appointmentRepo = appointmentRepo;
    }

    @GetMapping("/services")
    public List<Service> getAvailableServices() {
        return serviceRepo.findAll();
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment) {
        // For safety, verify service exists
        Long serviceId = appointment.getService().getId();
        Service service = serviceRepo.findById(serviceId).orElse(null);
        if(service == null) {
            return ResponseEntity.badRequest().body("Invalid Service ID");
        }
        appointment.setService(service);
        appointment.setBookedDate(service.getAvailableDate());
        appointment.setBookedTime(service.getAvailableTime());

        appointmentRepo.save(appointment);
        return ResponseEntity.ok("Appointment booked successfully");
    }
}
