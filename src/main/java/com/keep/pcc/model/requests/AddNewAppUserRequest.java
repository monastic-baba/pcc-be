package com.keep.pcc.model.requests;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AddNewAppUserRequest {
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String bio;
}
