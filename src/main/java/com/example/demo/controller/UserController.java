package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.util.Map;



@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAnyAuthority('Admin')")

public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String userList(Map<String,Object> model){
        Iterable<User> users = userRepo.findAll();
        model.put("user",users);

        return "userlist";
    }

    @GetMapping("/user")
    public String userEditForm(
            @RequestParam ("user") User user,
            Map<String, Object> model){


        model.put("user",user);
        model.put("roles",Role.values());
        return "userEdit";
    }
    @PostMapping("/savee")
    public String userSave(
            @RequestParam String username,
            @RequestParam String Admin,@RequestParam String User,
            @RequestParam("user") User user
    ) {
        user.setUsername(username);


        System.out.println(Admin);

user.getRoles().clear();

        user.getRoles().add(Role.Admin);



        userRepo.save(user);

        return "redirect:/";
    }


}
