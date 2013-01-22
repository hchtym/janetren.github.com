#! /bin/sh
# 这个脚本演示/dev/null的应用

# 读取/tmp/b.txt文件，但是将读取的内容输出到/dev/null
cat /tmp/b.txt >/dev/null

# 检索/etc下所有包含prince字符串的文件行，但是如果有错误信息，则输出到/dev/null
grep “prince” /etc/* 2> /dev/null

# 下面的命令更不不会产生任何输出：
# 如果b.txt文件存在，则读取的内容输出到/dev/null
# 如果b.txt文件不存在，则错误的信息输出到/dev/null
cat /tmp/b.txt >/dev/null 2>/dev/null

# 这个命令和上一条命令是等效的
cat /tmp/b.txt &>/dev/null

# 清空messages和wtmp文件中的内容，但是让文件依然存在并且不改变权限
cat /dev/null > /var/log/messages
cat /dev/null > /var/log/wtmp

