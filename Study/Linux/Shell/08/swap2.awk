function swap(array,    temp)							
＃注释1
{
  #交换array[1]和array[2]的值
  temp = array[1]
  array[1] = array[2]
  array[2] = temp
}
{
  array[1] = 2							＃注释2
  array[2] = 3
  printf("array[1]: %d----array[2]: %d\n", array[1], array[2])
  swap(array)							＃注释3
  printf("array[1]: %d----array[2]: %d\n", array[1], array[2])
}

