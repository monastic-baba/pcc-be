package com.keep.pcc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {

    private int id;
    private String name;

    @NotNull
    private String username;
    private String bio;
    private String email;
    private String password;
}
