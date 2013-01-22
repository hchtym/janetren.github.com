// main.c
#include <stdio.h>   // for printf
#include <stdlib.h>  // for malloc, free, srand, rand, system
#include <time.h>    // for time
#include "find_min.h"
#include "output_all.h"

int main()
{
	srand(time(NULL)); // ��ʱ����Ϊ���������
	// �����ΪSZ��, 0 <= SZ < 100
	const unsigned MOD = 100;
	unsigned SZ = rand() % MOD;
  // �ڶ��Ͽ���һ�οռ䣬�洢�����������
	unsigned* arr = (unsigned*)malloc(SZ * sizeof(SZ));
	unsigned k = 0;
	for(; k < SZ; ++k)
	  arr[k] = rand();

	output_all(arr, SZ);  // ������������������
	// �ҵ���С���Ǹ�������������������±�
  unsigned min = find_min(arr, SZ);
  // ������Ϸǿձ�Ȼ������Сֵ, �����
  if(0 != SZ)
    printf("minimum in all: %d\n", arr[min]);

  free(arr);	 // �ͷŷ���Ķ��ڴ�ռ�

  system("PAUSE");  // ��ϵͳ�ȴ����Ա����ǲ鿴����Ƿ���ȷ
  return 0;
}
