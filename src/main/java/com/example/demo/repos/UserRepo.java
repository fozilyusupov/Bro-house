package com.example.demo.repos;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findAllByUsername(String username);
     List <User> findById(long id);
     User findByUsername(String username);
    Iterable<User> findByRoles(Role roles);
    User findByLogin(String login);


}
