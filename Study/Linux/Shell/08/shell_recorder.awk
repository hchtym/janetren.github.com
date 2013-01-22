BEGIN {
  print "SHELL USAGE:"
}
/bash/{++bash}						# 支持的第一个匹配
/nologin/{++nologin}					# 支持的第二个匹配
END {
  print "We have " bash " bash users."
  print "We have " nologin " nologin users."
}

