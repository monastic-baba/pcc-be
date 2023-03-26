package com.keep.pcc.service;

import com.keep.pcc.model.entities.AppUser;
import java.util.List;

public interface AppUserService {
    AppUser addAppUser(AppUser appUser);
    List<AppUser> getAllAppUsers();
    AppUser getAppUserByUsername(String username);
}