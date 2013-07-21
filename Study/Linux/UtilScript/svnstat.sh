#!/bin/bash 
LIST="DevDept audit pRelease presale psDept psProject sitegroup smartcard smartcard_devgate studentPlatform zlmis"
for i in $LIST
do
  svn update --username tony   --password tony /data/svnclient/$i
  svn log --xml -v --username tony   --password tony /data/svnclient/$i > /data/svnclient/$i/svn.log
  java -jar /data/statsvn-0.7.0/statsvn.jar -title $i -charset utf-8 -disable-twitter-button  -exclude **/*.jar /data/svnclient/$i/svn.log /data/svnclient/$i -output-dir /var/www/html/statsvn/$i
done

