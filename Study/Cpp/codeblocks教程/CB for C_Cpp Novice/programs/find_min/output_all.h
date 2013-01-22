// output_all.h
#ifndef OUTPUT_ALL_H_
#define OUTPUT_ALL_H_

#include <stdio.h>  // for printf
void output_all(const unsigned* v, unsigned n)
{
	// ��������ÿ�����12�������
	const unsigned NL = 12, M = NL + 1;
	unsigned i = 0;
	for(; i < n; ++i)
	{
	  printf("%5d ", v[i]);
	  if(NL == i % M)  // ���ƻ���
	    printf("\n");
	}
	printf(0 == n ? "" : "\n");  // ���������Ϊ�ղ�����
}

#endif
