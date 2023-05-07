package com.keep.pcc.service;

import com.keep.pcc.exception.NotFoundException;
import com.keep.pcc.mapper.AppUserMapper;
import com.keep.pcc.model.requestDto.AppUserRequestDto;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.model.responseDto.AppUserResponseDto;
import com.keep.pcc.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public AppUserResponseDto addAppUser(AppUserRequestDto appUserRequestDto) {
        AppUser savedUser = appUserRepository.save(appUserMapper.appUserRequestDtoToAppUser(appUserRequestDto));
        return appUserMapper.appUserToAppUserResponseDto(savedUser);
    }

    @Override
    public List<AppUserResponseDto> getAllAppUsers() {
        return appUserRepository.findAll()
                .stream()
                .map( user -> appUserMapper.appUserToAppUserResponseDto(user))
                .collect(Collectors.toList());
    }


    @Override
    public AppUserResponseDto loginUser(Credential credential) {
        AppUser queriedUser = appUserRepository.findByUsername(credential.getUsername());
        if(queriedUser==null || !queriedUser.getPassword().equals(credential.getPassword())){
            throw new NotFoundException();
        }
        return appUserMapper.appUserToAppUserResponseDto(queriedUser);
    }

    @Override
    public AppUserResponseDto updateAppUser(int userId, AppUserRequestDto appUser) {
        Optional<AppUser> appUserToBeUpdated = appUserRepository.findById(userId);
        if(appUserToBeUpdated.isPresent()){
            AppUser appUserToUpdate = appUserToBeUpdated.get();
            if(!appUser.getName().isEmpty()) appUserToUpdate.setName(appUser.getName());
            if(!appUser.getUsername().isEmpty()) appUserToUpdate.setUsername(appUser.getUsername());
            if(!appUser.getBio().isEmpty()) appUserToUpdate.setBio(appUser.getBio());
            if(!appUser.getPassword().isEmpty()) appUserToUpdate.setPassword(appUser.getPassword());
            if(!appUser.getEmail().isEmpty()) appUserToUpdate.setEmail(appUser.getEmail());
            AppUser savedAppUser = appUserRepository.save(appUserToUpdate);
            return appUserMapper.appUserToAppUserResponseDto(savedAppUser);
        }
        else throw new NotFoundException();
    }
}
