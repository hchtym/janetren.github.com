BEGIN {
  print "Pick leap years:"
}
{
  year = $1													
#注释1
  if((year %4 == 0 && year % 100 != 0) || year % 400 == 0)				
#注释2
    print year " is a leap year."
  else
    print year " is not a leap year."
}

