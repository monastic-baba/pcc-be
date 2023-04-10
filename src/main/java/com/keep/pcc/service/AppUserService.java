package com.keep.pcc.service;

import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.entities.Credential;

import java.util.List;

public interface AppUserService {

    AppUserDto addAppUser(AppUserDto appUser);

    List<AppUserDto> getAllAppUsers();

    AppUserDto loginUser(Credential credential);
}