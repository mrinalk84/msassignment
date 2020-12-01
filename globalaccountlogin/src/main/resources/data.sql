DROP DATABASE IF EXISTS security;
CREATE DATABASE security;
USE security;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id INT auto_increment PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	phone_number VARCHAR(10) NOT NULL,
	username VARCHAR(12) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL,
	active BOOLEAN
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
	id INT auto_increment PRIMARY KEY,
	name VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles(
	id INT auto_increment PRIMARY KEY,
	user_id int NOT NULL,
	FOREIGN KEY(user_id) REFERENCES users(id),
	role_id int NOT NULL,
	FOREIGN KEY(role_id) REFERENCES roles(id)
);
-- The encrypted user pass `pass`
insert users values (default,'Mrinal','Jana', 'mrijana1@in.ibm.com', '9133138059', 'user','{bcrypt}$2a$10$cyf5NfobcruKQ8XGjUJkEegr9ZWFqaea6vjpXWEaSqTa2xL9wjgQC',1);
insert roles values (default,'ADMIN');
insert roles values (default,'USER');
insert roles values (default,'CLIENT');
insert user_roles values (default,1,3);
select * from users u join roles r JOIN user_roles ur on ur.user_id = u.id and r.id = ur.role_id;


CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256) NOT NULL,
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4000),
  autoapprove VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
);

CREATE TABLE IF NOT EXISTS oauth_code (
  code VARCHAR(256), authentication BLOB
);

-- The encrypted client_secret it `secret`
INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, authorized_grant_types, authorities, access_token_validity, autoapprove)
  VALUES ('clientId', '{bcrypt}$2a$10$vCXMWCn7fDZWOcLnIEhmK.74dvK1Eh8ae2WrWlhr2ETPLoxQctN4.','http://localhost:8210/home', 'read,write', 'password,refresh_token,client_credentials,authorization_code,implicit', 'ROLE_CLIENT', 300, 'true');