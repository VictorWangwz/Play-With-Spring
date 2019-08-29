create database coolapp;
use coolapp;
CREATE TABLE IF NOT EXISTS `user` (
`id` varchar(64) not null,
`username` varchar(64) default null,
`password` varchar(64) default null,
primary key (`id`)
)ENGINE=InnoDB default CHARSET=utf8;