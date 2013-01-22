BEGIN{
  FS=":"
}
{
  print "USER: "$1 "\tSHELL: "$7
}

