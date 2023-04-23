
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

insert into app_user (id, bio, email, name, password, username) values (1, 'dreamer', 'email1','Akash', 'password', 'akash1518');
insert into app_user (id, bio, email, name, password, username) values (2, 'thinker', 'email2','Puneet', 'password', 'teenup');
insert into app_user (id, bio, email, name, password, username) values (3, 'killer', 'email3','Chhavi', 'password', 'chavqueen');
insert into app_user (id, bio, email, name, password, username) values (4, 'shooter', 'email4','Samarth', 'password', 'smarth');
insert into app_user (id, bio, email, name, password, username) values (5, 'rider', 'email5','Kishore', 'password', 'kishore');
insert into app_user (id, bio, email, name, password, username) values (6, 'sailor', 'email6','Mukesh', 'password', 'mukesh');
insert into app_user (id, bio, email, name, password, username) values (7, 'attacker', 'email7','Anand', 'password', 'anand');
insert into app_user (id, bio, email, name, password, username) values (8, 'provider', 'email8','Rafi', 'password', 'mdrafi');
insert into app_user (id, bio, email, name, password, username) values (9, 'keeper', 'email9','Messi', 'password', 'goat');
insert into app_user (id, bio, email, name, password, username) values (10, 'player', 'email10','Ronaldo', 'password', 'cr7');
insert into app_user (id, bio, email, name, password, username) values (11, 'doer', 'email11','Mbappe', 'password', 'mvp');
insert into app_user (id, bio, email, name, password, username) values (12, 'winner', 'email12','Neymar', 'password', 'n10');