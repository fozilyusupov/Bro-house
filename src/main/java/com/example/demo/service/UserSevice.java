package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



    @Service
    public class UserSevice implements UserDetailsService {
        @Autowired
        private UserRepo userRepo;

        public UserSevice() {
        }

        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return (UserDetails) this.userRepo.findAllByUsername(username);
        }


        @Autowired
        public UserSevice(UserRepo userRepository) {
            this.userRepo = userRepository;
        }


    }

