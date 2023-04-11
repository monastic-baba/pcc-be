package com.keep.pcc.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keep.pcc.exception.NotFoundException;
import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Credential;
import com.keep.pcc.service.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebMvcTest(AppUserController.class)
class AppUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AppUserService appUserService;

    @Test
    void healthCheck() throws Exception {
        MvcResult mvcResult =  mockMvc.perform(
                MockMvcRequestBuilders.get("/appUser/health"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("healthy!",response,"app user controller not healthy");
    }

    @Test
    void addUser() throws Exception {
        AppUserDto mockAppUser = AppUserDto.builder().name("test").username("test_user").bio("bio").build();
        Mockito.when(appUserService.addAppUser(Mockito.any(AppUserDto.class))).thenReturn(mockAppUser);
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult addUserResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/appUser/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockAppUser))
                ).andReturn();
        AppUserDto response = objectMapper.readValue(addUserResponse.getResponse().getContentAsString(), AppUserDto.class);
        Assertions.assertEquals(mockAppUser, response,"user not added");
    }

    @Test
    void addNullUser() throws Exception {
        AppUserDto mockAppUser = AppUserDto.builder().name("test").bio("bio").build();
        Mockito.when(appUserService.addAppUser(Mockito.any(AppUserDto.class))).thenReturn(mockAppUser);
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult addUserResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/appUser/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockAppUser))
        ).andReturn();
        List<Map<String, String>> response = objectMapper.readValue(addUserResponse.getResponse().getContentAsString(), new TypeReference<List<Map<String, String>>>() {});
        Assertions.assertEquals(400, addUserResponse.getResponse().getStatus(),"null user added");
        Assertions.assertNotEquals(0, response.size(),"null user added");
    }

    @Test
    void loginSuccess() throws Exception {
        AppUserDto mockAppUser = AppUserDto.builder().name("test").username("test_user").build();
        Credential mockCredentialsValid = Credential.builder().username("test_user").password("password").build();
        Mockito.when(appUserService.loginUser(Mockito.any(Credential.class))).thenReturn(mockAppUser);
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult loginResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/appUser/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockCredentialsValid))
                ).andReturn();
        AppUser response = objectMapper.readValue(loginResponse.getResponse().getContentAsString(), AppUser.class);
        Assertions.assertEquals(mockAppUser.getName(), response.getName(), "login failed");
    }

    @Test
    void loginFail() throws Exception {
        Credential mockCredentialsInvalid = Credential.builder().username("test_user").password("wrongPass").build();
        Mockito.when(appUserService.loginUser(Mockito.any(Credential.class))).thenThrow(new NotFoundException());
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult loginResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/appUser/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockCredentialsInvalid))
        ).andReturn();
        Assertions.assertEquals("Value not found!", loginResponse.getResponse().getErrorMessage());
    }

    @Test
    void allUsers() throws Exception {
        List<AppUserDto> mockAllUsers = new ArrayList<AppUserDto>();
        mockAllUsers.add(AppUserDto.builder().name("test1").username("test_user1").build());
        mockAllUsers.add(AppUserDto.builder().name("test2").username("test_user2").build());
        mockAllUsers.add(AppUserDto.builder().name("test3").username("test_user3").build());
        Mockito.when(appUserService.getAllAppUsers()).thenReturn(mockAllUsers);
        MvcResult allUsersResponse = mockMvc.perform(MockMvcRequestBuilders.get("/appUser/all")).andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        List<AppUser> response = objectMapper.readValue(allUsersResponse.getResponse().getContentAsString(), new TypeReference<List<AppUser>>() {});
        Assertions.assertEquals(3, response.size());
        Assertions.assertEquals("test1", response.get(0).getName());
        Assertions.assertEquals("test_user2", response.get(1).getUsername());
    }
}