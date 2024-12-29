package com.jwt.example.controller;

import com.jwt.example.Entitties.Users;
import com.jwt.example.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

@Autowired
private Userservice userservice;

        @GetMapping("/users")
        public List<Users> getUser(){
            System.out.println("getting users");
            return userservice.getUsers();
        }
        @GetMapping("/current-user")
        public String getLoggedInUser(Principal principal){
            return principal.getName();
        }
    }

