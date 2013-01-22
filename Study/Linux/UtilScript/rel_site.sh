#!/bin/bash
service mysqld stop
service nginx stop
cp -Rf /opt/template/demo /opt/website/$1
cp /opt/template/nginx.sample /etc/nginx/conf.d/$1.conf
sed -i "s/{domain}/$1/g" /etc/nginx/conf.d/$1.conf
sed -i "s/{domain}/$1/g" /opt/website/$1/wp-config.php
cp /opt/template/demodb /var/lib/mysql
chown -R mysql:mysql /var/lib/mysql
chown -R nginx:nginx /opt/website
service mysqld start
service nginx start
