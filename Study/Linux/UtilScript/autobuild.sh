#!/bin/bash
#su - root
/bin/rm -rf /var/www/html/campuscard/test/*.*
sh /data/util_sh/splusKill.sh
unalias cp
#cd /data/svnclient/smartcard
#svn update /data/svnclient/smartcard
svn update /data/svnclient/splus_dev
#rm -rf /data/svnclient/smartcard/splus-ice-wisdragon/src/main/java/*
#rm -rf /data/svnclient/smartcard/splus-core/src/main/java/*
#rm -rf /data/svnclient/smartcard/splus-atom/src/main/java/*
#rm -rf /data/svnclient/smartcard/splus-main/src/main/java/*
#cp -Rf /data/svnclient/splus_dev/com.wisdragon.splus-ice/src/* /data/svnclient/smartcard/splus-ice-wisdragon/src/main/java
#cp -Rf /data/svnclient/splus_dev/com.wisdragon.splus-core/src/* /data/svnclient/smartcard/splus-core/src/main/java
#cp -Rf /data/svnclient/splus_dev/com.wisdragon.splus-atom/src/* /data/svnclient/smartcard/splus-atom/src/main/java
cd /data/svnclient/splus_dev
mvn clean
cd /data/svnclient/splus_dev/com.wisdragon.splus-ice
mvn compile
mvn deploy
cd /data/svnclient/splus_dev/com.wisdragon.splus-core
mvn compile
mvn deploy -Dmaven.test.skip=true
cd /data/svnclient/splus_dev/com.wisdragon.splus-atom
mvn compile
mvn deploy -Dmaven.test.skip=true
cd /data/svnclient/splus_dev/com.wisdragon.splus-main
mvn compile -P development
#cd /data/svnclient/splus_dev
#mvn site:site -Dmaven.test.skip=true
#cp -Rf /data/svnclient/smartcard/target/site/* /var/www/html/campuscard
#cp -Rf /data/svnclient/smartcard/splus-ice-wisdragon/target/site/* /var/www/html/campuscard/splus-ice-wisdragon
#cp -Rf /data/svnclient/smartcard/splus-atom/target/site/* /var/www/html/campuscard/splus-atom
#cp -Rf /data/svnclient/smartcard/splus-core/target/site/* /var/www/html/campuscard/splus-core
#cp -Rf /data/svnclient/smartcard/splus-main/target/site/* /var/www/html/campuscard/splus-main
mkdir -p /data/svnclient/splus_dev/com.wisdragon.splus-atom/target/classes/com/wisdragon/splus/atoms/msg/demo/
#cp -Rf /data/svnclient/splus_dev/com.wisdragon.splus-atom/src/com/wisdragon/splus/atoms/msg/demo/* /data/svnclient/splus_dev/com.wisdragon.splus-atom/target/classes/com/wisdragon/splus/atoms/msg/demo/
cd /data/svnclient/splus_dev/com.wisdragon.splus-main
mvn assembly:assembly -Dmaven.test.skip=true -P development
#mvn exec:java -Dexec.mainClass="com.wisdragon.splus.main.Run" -Dexec.args="/data/svnclient/splus_dev/"
cd /data/svnclient/splus_dev/com.wisdragon.splus-main/target
unzip -o /data/svnclient/splus_dev/com.wisdragon.splus-main/target/splus-main-1.0-SNAPSHOT-bin.zip
cp -f /data/svnclient/splus_dev/com.wisdragon.splus-configure/appli*.* /data/svnclient/splus_dev
cd /data/svnclient/splus_dev/com.wisdragon.splus-main/target/splus-main-1.0-SNAPSHOT
mkdir -p /data/svnclient/splus_dev/com.wisdragon.splus-main/target/splus-main-1.0-SNAPSHOT/atoms/com/wisdragon/splus/atoms/msg/demo
cp -Rf /data/svnclient/splus_dev/com.wisdragon.splus-configure/msgdemo/* /data/svnclient/splus_dev/com.wisdragon.splus-main/target/splus-main-1.0-SNAPSHOT/atoms/com/wisdragon/splus/atoms/msg/demo
cp -f /data/svnclient/splus_dev/com.wisdragon.splus-configure/appli*.* /data/svnclient/splus_dev/com.wisdragon.splus-main/target/splus-main-1.0-SNAPSHOT
chmod +x *.sh
dos2unix *.sh
./splusRun.sh &
#/data/util_sh/splusRun.sh &
echo "rebuild ok."
exit 0
