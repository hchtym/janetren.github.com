{
  print "\nField seperator = FS = \"" FS "\""
  n = split($0, array)									
#分割操作
  for(k = 1; k<=n; k++)
    print "array[" k "] = "  array[k]						
#打印分割后的字段
}

