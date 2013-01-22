#!/bin/sh
case $1 in
	*.jpg)	gqview $1;;
	*.txt)	gvim $1;;
	*.avi |  *.wmv)	mplayer $1;;
	*.pdf)	acroread $1;;
	*)	echo $1: Don't know how to read this file;;
esac

