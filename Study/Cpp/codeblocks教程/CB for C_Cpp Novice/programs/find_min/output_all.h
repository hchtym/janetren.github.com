// output_all.h
#ifndef OUTPUT_ALL_H_
#define OUTPUT_ALL_H_

#include <stdio.h>  // for printf
void output_all(const unsigned* v, unsigned n)
{
	// 输出结果中每行最多12个随机数
	const unsigned NL = 12, M = NL + 1;
	unsigned i = 0;
	for(; i < n; ++i)
	{
	  printf("%5d ", v[i]);
	  if(NL == i % M)  // 控制换行
	    printf("\n");
	}
	printf(0 == n ? "" : "\n");  // 随机数集合为空不换行
}

#endif
