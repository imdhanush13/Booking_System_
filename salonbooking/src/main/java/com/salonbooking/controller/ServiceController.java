package com.salonbooking.controller;

import com.salonbooking.model.Service;
import com.salonbooking.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    @PostMapping
    public Service add(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @PutMapping("/{id}")
    public Service update(@PathVariable Long id, @RequestBody Service service) {
        service.setId(id);
        return serviceRepository.save(service);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceRepository.deleteById(id);
    }
}
