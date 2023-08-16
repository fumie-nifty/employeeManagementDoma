--/*================================================================*/
--/*  データベース作成                                              */
--/*================================================================*/
DROP DATABASE IF EXISTS ufn58l;

CREATE DATABASE ufn58l DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

--/*================================================================*/
--/*  ユーザー作成                                                  */
--/*================================================================*/
DROP USER IF EXISTS 'ufn58l'@localhost;
DROP USER IF EXISTS 'ufn58l'@'%';

CREATE USER 'ufn58l'@localhost IDENTIFIED BY 'ufn58l';
CREATE USER 'ufn58l'@'%' IDENTIFIED BY 'ufn58l';

--/*================================================================*/
--/*  権限設定                                                      */
--/*================================================================*/
GRANT all ON ufn58l.* to 'ufn58l'@localhost;
GRANT all ON ufn58l.* to 'ufn58l'@'%';
FLUSH PRIVILEGES;
