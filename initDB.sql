CREATE TABLE users(
id serial,
firstname varchar(255),
lastname varchar(255),
phonenumber varchar(255));

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY(id