package com.keep.pcc.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="app_user_id")
    private int appUserId;

    @Column(name="post_id")
    private int postId;

    @Column(name="text")
    private String text;

    @Column(name= "likes")
    private int likes;

}