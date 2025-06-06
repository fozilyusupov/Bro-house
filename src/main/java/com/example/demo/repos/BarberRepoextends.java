package com.example.demo.repos;

import com.example.demo.domain.Barber;
import org.springframework.data.repository.CrudRepository;

   public interface BarberRepoextends extends CrudRepository<Barber, Long> {
}
