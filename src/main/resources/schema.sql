CREATE TABLE tb_users (
  id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NULL,
   username VARCHAR(255) NULL,
   password VARCHAR(255) NULL,
   CONSTRAINT pk_tb_users PRIMARY KEY (id)
);


CREATE TABLE tb_roles (
  id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NULL,
   CONSTRAINT pk_tb_roles PRIMARY KEY (id)
);



CREATE TABLE tb_role (
  users_id BIGINT NOT NULL,
   roles_id BIGINT NOT NULL
);

ALTER TABLE tb_role ADD CONSTRAINT fk_tb_role_on_roles FOREIGN KEY (roles_id) REFERENCES tb_roles (id);

ALTER TABLE tb_role ADD CONSTRAINT fk_tb_role_on_users FOREIGN KEY (users_id) REFERENCES tb_users (id);