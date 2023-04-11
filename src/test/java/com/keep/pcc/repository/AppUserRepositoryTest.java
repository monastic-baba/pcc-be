package com.keep.pcc.repository;

import com.keep.pcc.model.entities.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;


@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;

    @Test
    void testNameTooLong(){
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            AppUser mockAppUser = AppUser.builder().name("iamtoolongandbytoolongimeangreaterthan20").username("test").build();
            appUserRepository.save(mockAppUser);
            appUserRepository.flush();
        });
    }

    @Test
    void testSaveAppUser(){
        AppUser mockAppUser = AppUser.builder().username("test").build();
        AppUser savedUser = appUserRepository.save(mockAppUser);
        appUserRepository.flush();
        Assertions.assertNotNull(savedUser);
        Assertions.assertNotEquals(0, savedUser.getId());
    }



}