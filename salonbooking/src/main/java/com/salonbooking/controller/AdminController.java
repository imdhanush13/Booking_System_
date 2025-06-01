package com.salonbooking.controller;

import com.salonbooking.model.Service;
import com.salonbooking.model.Appointment;
import com.salonbooking.repository.ServiceRepository;
import com.salonbooking.repository.AppointmentRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ServiceRepository serviceRepo;
    private final AppointmentRepository appointmentRepo;

    public AdminController(ServiceRepository serviceRepo, AppointmentRepository appointmentRepo) {
        this.serviceRepo = serviceRepo;
        this.appointmentRepo = appointmentRepo;
    }

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceRepo.findAll();
    }

    @PostMapping("/services")
    public Service addService(@RequestBody Service service) {
        return serviceRepo.save(service);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service serviceDetails) {
        return serviceRepo.findById(id)
                .map(service -> {
                    service.setName(serviceDetails.getName());
                    service.setPrice(serviceDetails.getPrice());
                    service.setAvailableDate(serviceDetails.getAvailableDate());
                    service.setAvailableTime(serviceDetails.getAvailableTime());
                    serviceRepo.save(service);
                    return ResponseEntity.ok(service);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable Long id) {
        return serviceRepo.findById(id)
                .map(service -> {
                    serviceRepo.delete(service);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
}
