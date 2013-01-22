// main.c
#include <stdio.h>   // for printf
#include <stdlib.h>  // for malloc, free, srand, rand, system
#include <time.h>    // for time
#include "find_min.h"
#include "output_all.h"

int main()
{
	srand(time(NULL)); // 用时间作为随机数种子
	// 随机数为SZ个, 0 <= SZ < 100
	const unsigned MOD = 100;
	unsigned SZ = rand() % MOD;
  // 在堆上开辟一段空间，存储产生的随机数
	unsigned* arr = (unsigned*)malloc(SZ * sizeof(SZ));
	unsigned k = 0;
	for(; k < SZ; ++k)
	  arr[k] = rand();

	output_all(arr, SZ);  // 输出产生的所有随机数
	// 找到最小的那个随机数，并返回它的下标
  unsigned min = find_min(arr, SZ);
  // 如果集合非空必然存在最小值, 输出它
  if(0 != SZ)
    printf("minimum in all: %d\n", arr[min]);

  free(arr);	 // 释放分配的堆内存空间

  system("PAUSE");  // 让系统等待，以便我们查看结果是否正确
  return 0;
}
