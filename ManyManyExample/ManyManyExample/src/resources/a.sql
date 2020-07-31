drop database pubs;
create database pubs;
use pubs;
drop table TB_AUTHORS;
CREATE TABLE TB_AUTHORS (AUTHOR_ID int(11) NOT NULL default '0',AUTHOR_NAME varchar(30) default NULL,PRIMARY KEY (AUTHOR_ID)) ;
drop table TB_BOOKS;
CREATE TABLE TB_BOOKS (ISBN_CODE varchar(10) NOT NULL, BOOK_TITLE varchar(30) default NULL,PRIMARY KEY (ISBN_CODE)) ;
drop table TB_AUTHORS_BOOKS;
CREATE TABLE TB_AUTHORS_BOOKS (AUTHOR_ID_IN_MAP int(11) NOT NULL, ISBN_CODE varchar(10) not NULL);