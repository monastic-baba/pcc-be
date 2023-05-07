package com.keep.pcc.mapper;

import com.keep.pcc.model.requestDto.AppUserRequestDto;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.responseDto.AppUserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUser appUserRequestDtoToAppUser(AppUserRequestDto appUserRequestDto);
    AppUserResponseDto appUserToAppUserResponseDto(AppUser appUser);
}
