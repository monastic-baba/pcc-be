package com.keep.pcc.controller;

import com.keep.pcc.domain.AppUser;
import com.keep.pcc.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {

    AppUserService appUserService;

    @Autowired
    public RequestController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "healthy!";
    }

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name) {
        this.appUserService.updateAppUserName(1);
        return name + ", hello there!";
    }

    @GetMapping(value = "/users")
    public List<AppUser> appUsers() {
        return this.appUserService.getAllAppUsers();
    }
}