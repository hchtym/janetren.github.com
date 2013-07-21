#!/bin/bash 
LIST="QCG120509 DevDept SSFZ20121031shoushida YJYT120508 YJYT120508yingji YJYT121110 YJZ120508 YJZ120509 YJZ120509yunjiaozhi ZLWXX20130312 ZTJY121101zhuanti audit jichushuju pRelease presale psDept psProject sitegroup smartcard smartcard_devgate studentPlatform yunjiaozhi zlmis"
for i in $LIST
do
#    ps -u $LOGNAME -f |grep "$i"|grep -v "grep"|awk '{print "echo \"",$0,"\";","kill -9 ",$2}'|sh
  svn checkout http://svn.wisdragon.com/svn/$i    /data/svnclient/$i --username tony   --password tony
done


#svn checkout http://192.168.3.254/svn/$library    /var/www/html/statsvn/$library --username tony   --password tony
