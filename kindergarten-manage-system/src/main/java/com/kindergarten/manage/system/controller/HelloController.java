package com.kindergarten.manage.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world current date:" + LocalDateTime.now();
    }

    @RolesAllowed({"USER"})
    @RequestMapping("/user")
    public String user() {
        return "User List current date:" + LocalDateTime.now();
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping("/admin")
    public String admin() {
        return "Admin List current date:" + LocalDateTime.now();
    }
}
