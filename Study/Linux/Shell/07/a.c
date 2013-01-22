#include <stdio.h>
#include <math.h>

long int power(int, int);

int main() {
  int base, n;
  scanf("%d, %d\n", &base, &n);
  printf("The power is: %d\n", power(base, n));
}

long int power(int base, int n)
{
  return base^n;
}

