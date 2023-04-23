
    drop table if exists app_user cascade;

    drop table if exists bucket cascade;

    drop table if exists comment cascade;

    drop table if exists post cascade;

    drop table if exists tag cascade;

    drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;

    create table app_user (
       id int4 not null,
        bio varchar(255),
        email varchar(255),
        name varchar(20),
        password varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    create table bucket (
       id int4 not null,
        name varchar(255),
        primary key (id)
    );

    create table comment (
       id int4 not null,
        app_user_id int4,
        likes int4,
        post_id int4,
        text varchar(255),
        primary key (id)
    );

    create table post (
       id int4 not null,
        app_user_id int4,
        bucket_id varchar(255),
        caption varchar(255),
        primary key (id)
    );

    create table tag (
       id int4 not null,
        bucket_id int4,
        name varchar(255),
        primary key (id)
    );
