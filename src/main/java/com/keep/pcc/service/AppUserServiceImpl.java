package com.keep.pcc.service;

import com.keep.pcc.exception.NotFoundException;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser addAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }


    @Override
    public AppUser loginUser(Credential credential) {
        AppUser queriedUser = appUserRepository.findAppUsersByUsername(credential.getUsername());
        if(queriedUser.getPassword().equals(credential.getPassword())){
            throw new NotFoundException();
        }
        return queriedUser;
    }
}
