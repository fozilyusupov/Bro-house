package com.example.demo.repos;

import com.example.demo.domain.Klient;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepo  extends CrudRepository<Klient, Long> {

}
