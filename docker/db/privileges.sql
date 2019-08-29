use mysql;
update user set host = "%" where user='root';
ALter user 'root'@'%' identified WITH mysql_native_password by '00000000';
flush privileges ;