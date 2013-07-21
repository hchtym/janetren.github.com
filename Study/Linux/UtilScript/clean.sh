#!/bin/bash
#delete expire file leave lastest 3 files
FILES="$1"*.tar.gz
xxx=`ls -1 $FILES  2>/dev/null | wc -l`
if [ $xxx -gt 3 ]
then
  echo "delete old files "
  yyy=`expr $xxx - 3`
  for i in `ls -1t $FILES| tail -$yyy`
  do
    echo "rm -f $i"
    rm -f $i
  done
fi


exit 0

