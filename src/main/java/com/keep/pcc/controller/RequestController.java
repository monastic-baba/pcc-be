package com.keep.pcc.controller;

import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.requests.AddNewAppUserRequest;
import com.keep.pcc.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
//import javax.validation.Valid;
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


    @Transactional
    @PostMapping(value = "/signup")
    public String createNudge(@RequestBody AppUser appUser) {
        this.appUserService.addAppUser(appUser);
        return "user successfully added!";
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