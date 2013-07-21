#!/bin/bash
/usr/bin/rsync -avz --progress --delete --password-file=/etc/rsyncd.passwd root@svn.wisdragon.com::alldata/util_sh /home/wisdragon/rsync
/usr/bin/rsync -avzu --progress --delete --password-file=/etc/rsyncd.passwd root@svn.wisdragon.com::alldata/svnrepository /home/svn
