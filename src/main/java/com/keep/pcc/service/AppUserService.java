package com.keep.pcc.service;

import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    AppUser addAppUser(AppUser appUser);

    List<AppUser> getAllAppUsers();

    AppUser loginUser(Credential credential);
}