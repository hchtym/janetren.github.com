BEGIN {
  FS="[ |,]";								＃注释1
  OFS=","
}
NR <= FNR {								＃注释2
  a[$2]=$1
}
NR>FNR {									
＃注释3
  print $1,$2,a[$2]
}

