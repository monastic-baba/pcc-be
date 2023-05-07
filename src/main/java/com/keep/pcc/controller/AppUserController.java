package com.keep.pcc.controller;

import com.keep.pcc.model.requestDto.AppUserRequestDto;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.model.responseDto.AppUserResponseDto;
import com.keep.pcc.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping(value = "/signup")
    public ResponseEntity<AppUserResponseDto> addNewAppUser(@Validated @RequestBody AppUserRequestDto appUser) {
        AppUserResponseDto newUser = this.appUserService.addAppUser(appUser);
        return ResponseEntity.ok(newUser);
    }

    @PatchMapping(value = "/update/{userId}")
    public ResponseEntity<AppUserResponseDto> updateUser(@PathVariable int userId, @Validated @RequestBody AppUserRequestDto appUser){
        AppUserResponseDto newUser = this.appUserService.updateAppUser(userId, appUser);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AppUserResponseDto> login(@RequestBody Credential credential) {
        AppUserResponseDto loggedInUser = this.appUserService.loginUser(credential);
            return ResponseEntity.ok(loggedInUser);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AppUserResponseDto>> appUsers() {
        return ResponseEntity.ok(this.appUserService.getAllAppUsers());
    }
}