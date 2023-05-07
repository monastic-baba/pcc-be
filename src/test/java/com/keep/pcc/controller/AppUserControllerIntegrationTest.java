package com.keep.pcc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keep.pcc.mapper.AppUserMapper;
import com.keep.pcc.model.requestDto.AppUserRequestDto;
import com.keep.pcc.model.responseDto.AppUserResponseDto;
import com.keep.pcc.repository.AppUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@SpringBootTest
class AppUserControllerIntegrationTest {

    @Autowired
    AppUserController appUserController;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserMapper appUserMapper;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void addUserBadName() throws Exception {
        AppUserRequestDto mockAppUser = AppUserRequestDto.builder().name("iamtoolongandbytoolongimeangreaterthan20").username("test_user").bio("bio").build();
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult addUserResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/appUser/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockAppUser))
        ).andReturn();
        Assertions.assertEquals(400, addUserResponse.getResponse().getStatus(),"trying to add bad user");
    }

    @Rollback
    @Transactional
    @Test
    void testAddUserAndGetAllAppUsers(){
        ResponseEntity<List<AppUserResponseDto>> usersInDb = appUserController.appUsers();
        Assertions.assertEquals(0, Objects.requireNonNull(usersInDb.getBody()).size());
        AppUserRequestDto mockAppUser = AppUserRequestDto.builder().username("username").build();
        appUserController.addNewAppUser(mockAppUser);
        usersInDb = appUserController.appUsers();
        Assertions.assertEquals(1, Objects.requireNonNull(usersInDb.getBody()).size());
    }

}