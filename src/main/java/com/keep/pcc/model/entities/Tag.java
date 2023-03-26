package com.keep.pcc.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name= "bucket_id")
    private int bucketId;
}