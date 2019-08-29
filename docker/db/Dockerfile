FROM mysql/mysql-server
COPY dbInit.sql /dbInit.sql
COPY privileges.sql /privileges.sql
COPY setup.sh /setup.sh
ENV MYSQL_ROOT_PASSWORD 00000000
EXPOSE 3306
RUN chmod a+x /setup.sh