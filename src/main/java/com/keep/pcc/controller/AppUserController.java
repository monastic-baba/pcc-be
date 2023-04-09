package com.keep.pcc.controller;

import com.keep.pcc.exception.NotFoundException;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        AppUser newUser = this.appUserService.addAppUser(appUser);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AppUser> login(@RequestBody Credential credential) {
            AppUser loggedInUser = this.appUserService.loginUser(credential);
            return ResponseEntity.ok(loggedInUser);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AppUser>> appUsers() {
        return ResponseEntity.ok(this.appUserService.getAllAppUsers());
    }
}