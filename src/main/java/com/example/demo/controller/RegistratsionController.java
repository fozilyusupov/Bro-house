package com.example.demo.controller;

import com.example.demo.domain.Barber;
import com.example.demo.domain.Massage;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repos.MassagerRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistratsionController {
    @Autowired
    private MassagerRepo massagerRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/resistratsiya")
    public String regestratsion(){
        return "resistratsiya";
    }

    @PostMapping("/resistratsiya")
    public String adduser(User user, Map<String, Object> model){

    User userFromDb=userRepo.findAllByUsername(user.getUsername());

    if (userFromDb != null){
      model.put("massege", "User exists!");
      return "resistratsiya";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.User));
    userRepo.save(user);


        Iterable<User> barbers = userRepo.findAll();
        model.put("bar", barbers);

        return "redirect:/barber";
    }
    @GetMapping("/jadval")
    public String jadvaShow(Map<String, Object> model){

        Iterable<Massage> massages = massagerRepo.findAll();
        model.put("massages", massages);
        return "jadval";
    }




}
