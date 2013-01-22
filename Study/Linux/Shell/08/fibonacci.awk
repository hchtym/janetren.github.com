function fibonacci(nth) 
{
  if (nth == 1 || nth == 2)								
＃注释1
    return 1
  else
    return fibonacci(nth-1)+fibonacci(nth-2)						
＃注释2
}
{
  n = $1 
  printf(" %dth of fibonacci sequence is: %d\n", n, fibonacci(n))  
}

