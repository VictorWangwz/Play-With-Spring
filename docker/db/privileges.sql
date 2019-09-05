use mysql;
update userEntity set host = "%" where userEntity='root';
ALter userEntity 'root'@'%' identified WITH mysql_native_password by '00000000';
flush privileges ;