package com.keep.pcc.controller;

import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/appUser")
public class AppUserController {

    AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "healthy!";
    }


    @Transactional
    @PostMapping(value = "/signup")
    public String addUser(@RequestBody AppUser appUser) {
        AppUser newUser = this.appUserService.addAppUser(appUser);
        return newUser.getName() + " added!";
    }

    @PostMapping(value = "/login")
    public AppUser getUser(@RequestBody Credential credential) {
        try {
            AppUser queriedUser =  this.appUserService.getAppUserByUsername(credential.getUsername());
            return queriedUser.getPassword().equals(credential.getPassword()) ? queriedUser : null;
        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping(value = "/all")
    public List<AppUser> appUsers() {
        return this.appUserService.getAllAppUsers();
    }
}