package com.keep.pcc.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="app_user_id")
    private int appUserId;

    @Column(name= "caption")
    private String caption;

    @Column(name= "bucket_id")
    private String bucketId;

}