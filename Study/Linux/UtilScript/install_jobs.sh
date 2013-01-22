#!/bin/bash
if [ $# -ne 1 ] ; then
  echo "please input userid"
  exit 1
fi
echo "Installing monitor plan for tomcat"
cat >> /var/spool/cron/root << EOF
* * * * * /opt/sungard/util_sh/mon_v3web.sh
EOF
