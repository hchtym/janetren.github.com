#!/bin/bash
PROCCESSES="tomcatForWebapps tomcatForEcard"
date=`date +'%Y%m%d %H:%M:%S'`
for i in $PROCCESSES
do
  smspid=`ps aux |grep "$i" |grep -v "grep"|grep -v "tail" |awk '{print $2}'`
  LOGFILE="/var/log/mon_$i.log"
  if [ "$smspid" != "" ] ; then
    echo "$date - pid is $smspid" >> $LOGFILE
  else
    su - root -c "/opt/sungard/$i/bin/startup.sh & " 
    echo "$date - new $i process is running!!!" >> $LOGFILE
  fi
done


