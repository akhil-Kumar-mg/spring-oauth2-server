package com.caremanager.springsecurityoracledb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@EnableResourceServer
@RestController
public class HelloController {

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

}
