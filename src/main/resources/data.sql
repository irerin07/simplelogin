insert into users(id, email ,username,  passwd) values (1, 'counterchord89@gmail.com', 'irerin', '{noop}359751');
insert into roles(id, name) values (1, 'ROLE_ADMIN');
insert into roles(id, name) values (2, 'ROLE_USER');
insert into user_roles(user_id,roles, role_id) values(1, 'ROLE_ADMIN', 1);
insert into user_roles(user_id, roles, role_id) values(1,'ROLE_USER', 2);