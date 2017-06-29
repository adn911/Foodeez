INSERT INTO test.user (version,email,enabled,locked,password,userId) VALUES (0, 'admin@test.com', 1, 0, '123456', 'admin');
INSERT INTO test.user_role (userType,user_id) VALUES ( '0', '1');
INSERT INTO test.user_role (userType,user_id) VALUES ( '1', '1');
