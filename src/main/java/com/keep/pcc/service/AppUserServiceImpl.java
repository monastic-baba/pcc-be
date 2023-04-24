package com.keep.pcc.service;

import com.keep.pcc.exception.NotFoundException;
import com.keep.pcc.mapper.AppUserMapper;
import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    AppUserRepository appUserRepository;
    AppUserMapper appUserMapper;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, AppUserMapper appUserMapper) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
    }

    @Override
    public AppUserDto addAppUser(AppUserDto appUserDto) {
        AppUser savedUser = appUserRepository.save(appUserMapper.appUserDtoToAppUser(appUserDto));
        return appUserMapper.appUserToAppUserDto(savedUser);
    }

    @Override
    public List<AppUserDto> getAllAppUsers() {
        return appUserRepository.findAll()
                .stream()
                .map( user -> appUserMapper.appUserToAppUserDto(user))
                .collect(Collectors.toList());
    }


    @Override
    public AppUserDto loginUser(Credential credential) {
        AppUser queriedUser = appUserRepository.findByUsername(credential.getUsername());
        if(queriedUser==null || !queriedUser.getPassword().equals(credential.getPassword())){
            throw new NotFoundException();
        }
        return appUserMapper.appUserToAppUserDto(queriedUser);
    }
}
