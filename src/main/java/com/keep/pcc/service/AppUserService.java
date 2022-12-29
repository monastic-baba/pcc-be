package com.keep.pcc.service;

import com.keep.pcc.domain.AppUser;
import java.util.List;

public interface AppUserService {
    void addAppUser(AppUser appUser);
    List<AppUser> getAllAppUsers();
    AppUser getAppUserById(int id);
    void updateAppUserName(int id);
    void deleteAppUserById(int id);
}