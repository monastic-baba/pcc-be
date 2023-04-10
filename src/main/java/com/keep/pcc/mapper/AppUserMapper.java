package com.keep.pcc.mapper;

import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.entities.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUser appUserDtoToAppUser(AppUserDto appUserDto);
    AppUserDto appUserToAppUserDto(AppUser appUser);
}
