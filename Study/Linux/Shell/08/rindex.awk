function rindex(string, find,      k, ns, nf)
{
  # 返回string中最后一个出现的find索引
  # 如果没有找到find，则返回0
  ns = length(string)
  nf = length(find)
  for(k = ns+1-nf; k>=1; k--)
    if(substr(string,k,nf) == find)
      return k
  return 0
}
{
  string = $1
  find = $2
  printf("Reverse index of %s in %s is: %d\n", find, string, rindex(string, find))
}

