create database ssi;  
use ssi; 
DROP TABLE IF EXISTS T_IKMS_USER;
CREATE TABLE T_IKMS_USER (
  USER_ID varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  USER_ACCOUNT varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  USER_NAME varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  USER_PASSWORD varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  NICK_NAME varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  USER_SOURCE varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  CREATE_DATE DATATIME NOT NULL,
  PRIMARY KEY (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO T_IKMS_USER VALUES ('00000000-0000-0000-0000-000000000000', 'demo', 'demo');