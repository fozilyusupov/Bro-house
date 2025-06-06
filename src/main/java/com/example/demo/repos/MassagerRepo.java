package com.example.demo.repos;

import com.example.demo.domain.Massage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MassagerRepo extends CrudRepository<Massage, Long> {

    List<Massage> findByBarbernameAndStatus(String barbername,boolean status);
    List<Massage>findByStatus(boolean status);
    List<Massage>findByBarbername(String barbername);
    List<Massage>findAll();
    //List<Massage>findById(long id);
        Massage findById(long id);



}
