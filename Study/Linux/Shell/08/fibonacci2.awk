function fibonacci(array,n,    ind)				#定义函数
{
  ind = 3
  while(ind <= n)
  {
    array[ind] = array[ind-1] + array[ind-2]			#递归调用
    ind++
  }
}
{
  array[1] = 1
  array[2] = 1
  n = $1 
  fibonacci(array, n)				#调用入口
  printf(" %dth of fibonacci sequence is: %d\n", n, array[n])
}

