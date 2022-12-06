package com.kindergarten.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RequestMapping("/login/error")
    public String error() {
        return "Error current date:" + LocalDateTime.now();
    }

    @RequestMapping("/index")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return "Index current date:" + LocalDateTime.now();
    }
    @PreAuthorize("hasRole('user')")
    @RequestMapping("/user")
    public String user() {
        return "User List current date:" + LocalDateTime.now();
    }

    @PreAuthorize("hasRole('ROLE_admin')")
    @RequestMapping("/admin")
    public String admin() {
        return "Admin List current date:" + LocalDateTime.now();
    }
}
