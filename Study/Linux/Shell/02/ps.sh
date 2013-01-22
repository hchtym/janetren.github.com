#! /bin/sh
# shell参数传递演示，查看系统中某进程是否正在运行
# 记得使用chmod +x 使ps.sh可运行

ps -eLf | grep $1					#ps命令查看当前系统进程
