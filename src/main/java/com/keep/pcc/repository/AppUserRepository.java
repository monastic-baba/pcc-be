package com.keep.pcc.repository;

import com.keep.pcc.model.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Transactional
    @Modifying
    @Query("update AppUser au set au.name = :name where au.id = :id")
    void setName(@Param("name") String name, @Param("id") int id);

    AppUser findByUsername(String username);
}