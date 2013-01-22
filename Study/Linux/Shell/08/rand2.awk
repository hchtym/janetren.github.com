function myrand()					＃注释1
{
  x = 16807*x % (2^31-1)
  return x
}
function mysrand(xx)				＃注释2
{
  if(xx)
    x = xx
  else
    x = systime()
}
{
  mysrand($1)					＃注释3
  print myrand()
  print myrand()
  mysrand()						＃注释4
  print myrand()
  print myrand()
}

