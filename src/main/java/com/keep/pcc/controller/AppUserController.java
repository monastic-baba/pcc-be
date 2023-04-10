package com.keep.pcc.controller;

import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AppUserDto> addUser(@RequestBody AppUserDto appUser) {
        AppUserDto newUser = this.appUserService.addAppUser(appUser);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AppUserDto> login(@RequestBody Credential credential) {
            AppUserDto loggedInUser = this.appUserService.loginUser(credential);
            return ResponseEntity.ok(loggedInUser);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AppUserDto>> appUsers() {
        return ResponseEntity.ok(this.appUserService.getAllAppUsers());
    }
}