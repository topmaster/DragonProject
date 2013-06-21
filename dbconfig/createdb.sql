drop table if exists contact;
drop table if exists aim;
drop table if exists charges;
drop table if exists goods_category;
drop table if exists users;
drop table if exists role;
drop table if exists aim_category;

create table role (
    role_id int not null auto_increment,
    role_name varchar (255) not null unique,
    constraint pk_role primary key (role_id)
);

create table users (
    user_id int not null auto_increment,
    username varchar (255) not null unique,
    password varchar (255) not null,
    fk_role_id int not null,
    constraint pk_user primary key (user_id),
    foreign key (fk_role_id) references role (role_id)
);

create table goods_category (
    goods_category_id int not null auto_increment,
    goods_category_name varchar (255) not null unique,
    constraint pk_goods_category primary key (goods_category_id)
);

create table charges (
    charges_id int not null auto_increment,
    charges_article varchar (255) not null,
    payment_date varchar (11) not null,
    fk_goods_category_id int not null,
    fk_user_id int not null,
    constraint pk_charges primary key (charges_id),
    foreign key (fk_goods_category_id) references goods_category (goods_category_id),
    foreign key (fk_user_id) references users (user_id)
);

create table contact (
    contact_id int not null auto_increment,
    firstname varchar (255) not null,
    lastname varchar (255) not null,
    middlename varchar (255),
    email varchar (255) not null,
    mobile_number varchar (255),
    work_phone_number varchar (255),
    birthdate varchar (13),
    comments text,
    contact_type int not null,
    fk_user_id int not null,
    constraint pk_contact primary key (contact_id),
    foreign key (fk_user_id) references users (user_id)
);

create table aim_category (
    aim_category_id int not null auto_increment,
    important boolean not null,
    urgently boolean not null,
    long_term boolean not null,
    constraint pk_aim_category primary key (aim_category_id)
);

create table aim (
    aim_id int not null  auto_increment,
    aim_name varchar (255) not null,
    short_descr varchar (255) not null,
    long_descr varchar (1024) not null,
    plane_date varchar (11) not null,
    red_line varchar (11) not null,
    fk_aim_category_id int not null ,
    fk_user_id int not null,
    constraint pk_aim primary key (aim_id),
    foreign key (fk_aim_category_id) references aim_category (aim_category_id),
    foreign key (fk_user_id) references users (user_id)
);

INSERT INTO role(role_id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO users(username, password, fk_role_id) VALUES ('foo', 'bar', 1);