package com.keep.pcc.service;

import com.keep.pcc.model.requestDto.AppUserRequestDto;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.model.responseDto.AppUserResponseDto;

import java.util.List;

public interface AppUserService {

    AppUserResponseDto addAppUser(AppUserRequestDto appUserRequestDto);

    List<AppUserResponseDto> getAllAppUsers();

    AppUserResponseDto loginUser(Credential credential);

    AppUserResponseDto updateAppUser(int userId, AppUserRequestDto appUser);
}