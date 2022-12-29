package com.keep.pcc.service;

import com.keep.pcc.domain.AppUser;
import com.keep.pcc.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void addAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getAppUserById(int id) {
        return appUserRepository.getReferenceById(id);
    }

    @Override
    public void updateAppUserName(int id) {
        appUserRepository.setName("New name!", id);
    }

    @Override
    public void deleteAppUserById(int id) {
    appUserRepository.deleteById(id);
    }
}
