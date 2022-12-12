INSERT INTO ts.service( desktop, laptop, mac, name, duration) VALUES (50, 50, 200, 'FORMATLAMA', 2);
INSERT INTO ts.service( desktop, laptop, mac, name, duration) VALUES (100, 100, 100, 'VIRUS', 4);
INSERT INTO ts.service( desktop, laptop, mac, name, duration) VALUES (200, 200, 400, 'DISK KURTARMA', 10);
INSERT INTO ts.service( desktop, laptop, mac, name, duration) VALUES (30, 100, 200, 'TEMIZLIK', 1);

insert into ts.role (name) VALUES ('ROLE_ADMIN');
insert into ts.role (name) VALUES ('ROLE_USER');
--1234
insert into ts.system_user (email, name, password) VALUES ( '1@1.com', 'admin', '$2a$10$WDtUVEjZuuQ7YNOfweEOu.5BxWq/yRH/LIyU9jv0g.TYjP8DfiMfC');
insert into ts.system_user (email, name, password) VALUES ( '2@2.com', 'kullanici', '$2a$10$WDtUVEjZuuQ7YNOfweEOu.5BxWq/yRH/LIyU9jv0g.TYjP8DfiMfC');

insert into ts.system_user_roles (system_user_id, roles_id)VALUES (1, 1);
insert into ts.system_user_roles (system_user_id, roles_id)VALUES (2, 2);

INSERT INTO ts.product( name) VALUES ('GPU');
INSERT INTO ts.product( name) VALUES ('CPU');
INSERT INTO ts.product( name) VALUES ('Anakart');
INSERT INTO ts.product( name) VALUES ('RAM');