use solrdb;
show tables;
create table users(
 id int AUTO_INCREMENT,
 username varchar(100),
 password varchar(100),
 CONSTRAINT user_pk PRIMARY KEY(`id`)
 );
 create table roles(
 id int AUTO_INCREMENT,
 rolename varchar(100),
 CONSTRAINT role_pk PRIMARY KEY(`id`)
 );
 
 create table user_roles(
  id int AUTO_INCREMENT,
  user_id int NOT NULL,
  role_id int NOT NULL,
  CONSTRAINT user_roles_pk PRIMARY KEY(`id`),
  CONSTRAINT  fk_user_id FOREIGN KEY (`user_id`) REFERENCES users(`id`),
  CONSTRAINT  fk_role_id FOREIGN KEY (`role_id`) REFERENCES roles (`id`)
  );
  
