package com.salonbooking.config;

import com.salonbooking.model.Service;
import com.salonbooking.model.User;
import com.salonbooking.repository.ServiceRepository;
import com.salonbooking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepo, ServiceRepository serviceRepo, PasswordEncoder encoder) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepo.save(admin);
            }

            if(serviceRepo.count() == 0) {
                Service s1 = new Service();
                s1.setName("Haircut");
                s1.setPrice(20);
                s1.setAvailableDate(LocalDate.now().plusDays(1));
                s1.setAvailableTime(LocalTime.of(10, 0));
                serviceRepo.save(s1);

                Service s2 = new Service();
                s2.setName("Facial");
                s2.setPrice(30);
                s2.setAvailableDate(LocalDate.now().plusDays(2));
                s2.setAvailableTime(LocalTime.of(14, 0));
                serviceRepo.save(s2);
            }
        };
    }
}
