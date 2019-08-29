#!/bin/bash
mysql -u root -p$MYSQL_ROOT_PASSWORD <<EOF
source privileges.sql;
source dbInit.sql;
