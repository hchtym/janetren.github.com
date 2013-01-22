function add(x,y,    sum)			#注释1
{
  #对x和y求和并返回
  sum = x + y
  return sum
}
{
  m = 2
  n = 3
  x = add(m,n)			#注释2
  printf("m: %d\n", m)
  printf("n: %d\n", n)
  printf("sum of m and n is %d\n", x)			#注释3
}

