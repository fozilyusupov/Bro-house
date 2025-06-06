package com.example.demo.repos;


import com.example.demo.domain.BarberKPI;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BarberKPIRepo extends CrudRepository<BarberKPI, Long> {
    List<BarberKPI>findByNameAndStatus(String name,boolean status);
    List<BarberKPI>findByStatus(boolean status);
    BarberKPI findById(long id);
}
