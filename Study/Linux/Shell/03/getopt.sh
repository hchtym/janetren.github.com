#!/bin/sh
author=false
list=false
file=""

while [ $# -gt 0 ]
do
	case $1 in
	-f)	file=$2					
#将-f参数的下一个参数（file）获取至file变量
		shift						#截去下一个参数
		;;
	-l)	list=true
		;;
	-a)	author=true
		;;
	--)	shift						
#传统上，以--结束选项
		break
		;;
	-*)	echo $0: $1: unrecognized option
		;;
	*)	break					
#无选项参数时，在循环中跳出
		;;
	esac
	shift							#参数偏移
done

