#!/bin/bash
ftp -v -n 101.226.241.136 <<END_SCRIPT
user wisdragon wd12345678
bin
hash
cd /
lcd /u01/backup
prompt
mput $TARFILE
bye
END_SCRIPT

exit 0
