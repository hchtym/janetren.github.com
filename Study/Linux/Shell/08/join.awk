function join(array, n, fs,        k, s)
{
  # 重新将array中各个字符串拼接成一个字符串
  # 并以fs分割数组元素
  if (n >= 1)
  {
    s = array[1]
    for(k=2;k<=n;k++)
      s = s fs array[k]
  }
  return s
}

