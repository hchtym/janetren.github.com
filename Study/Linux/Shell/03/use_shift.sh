#! /bin/sh
# 依次读取文件
while [ -e $1 ];
do
	cat $1								
#此处可以替换成其他的文件处理
	Shift
done

