#! /bin/sh
# 判断某用户是否存在

line = rep $1 /etc/passwd		#查找用户名是否在/etc/passwd中
if [ -z line ]
	echo "user $1 exists."
fi

