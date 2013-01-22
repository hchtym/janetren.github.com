function swap(x,y,    temp)
{
  #交换x和y的值
  temp = x
  x = y
  y = temp			＃在这里，尝试交换x和y
}
{
  m = 2
  n = 3
  printf("m: %d----n: %d\n", m, n)			#打印m和n的初始值
  swap(m,n)
  printf("m: %d----n: %d\n", m, n)			#打印m和n的新值
}

