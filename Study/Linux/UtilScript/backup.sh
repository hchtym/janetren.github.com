#!/bin/bash
DATE=`date '+%Y%m%d'`
tar cvfz /home/wisdragon/nhcrm-$DATE.tar.gz /home/newheights/www
service mysqld stop
tar cvfz /home/wisdragon/mysql-$DATE.tar.gz /var/lib/mysql
service mysqld start
