package com.example.demo.repos;

import com.example.demo.domain.strishka;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface strishkaRepo extends CrudRepository<strishka,Long> {
    strishka findBySrishkaType(String srishkaType);
}
