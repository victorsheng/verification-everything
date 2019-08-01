CREATE DATABASE local_td_atf CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'local_td_atf'@'%' IDENTIFIED BY 'local_td_atf';

GRANT all privileges  on local_td_atf.* TO 'local_td_atf'@'%';

flush privileges;