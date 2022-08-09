INSERT
INTO
  tb_users
  (nome, username, password)
VALUES
  ('Eloá Cardozo', 'eloaca', 'eloaca');

INSERT
INTO
  tb_users
  (nome, username, password)
VALUES
  ('Admin Cardozo', 'admin', 'admin');



INSERT
INTO
  tb_roles
  (nome)
VALUES
  ('USERS');

INSERT
INTO
  tb_roles
  (nome)
VALUES
  ('MANAGERS');



INSERT
INTO
  tb_role
  (Users_id, roles_id)
VALUES
  (1, 1);
INSERT
INTO
  tb_role
  (Users_id, roles_id)
VALUES
  (2, 1);
INSERT
INTO
  tb_role
  (Users_id, roles_id)
VALUES
  (2, 2);