package com.example.demo.repos;


import com.example.demo.domain.BarberSalary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BarberSalaryRepo extends CrudRepository<BarberSalary, Long> {
    List<BarberSalary>findByBarbername(String barbername);
    List<BarberSalary>findByStatus(boolean status);
    List<BarberSalary>findByBarbernameAndDate(String barbername,String date);
}
