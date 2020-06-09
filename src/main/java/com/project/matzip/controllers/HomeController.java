package com.project.matzip.controllers;


import com.project.matzip.entities.Role;
import com.project.matzip.entities.User;
import com.project.matzip.service.RoleService;
import com.project.matzip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashSet;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/")
    public String index() {
        if (userService.getUser("admin") == null) {
            userService.save(new User("admin",
                    "email", "admin", "000",
                    new HashSet<Role>(Arrays.asList(roleService.getRole("ADMIN"), roleService.getRole("USER")))));


        }
        return "main";
    }

    @RequestMapping(value = "/restWrite")
    public String restWrite() {
        return "restWrite";
    }

    @RequestMapping(value = "/signup")
    public String signUp() { return "signup"; }

    @RequestMapping(value = "/login")
    public String login() { return "login"; }

}
