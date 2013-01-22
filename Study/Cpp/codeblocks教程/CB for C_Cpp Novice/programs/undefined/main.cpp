// main.cpp
#include <iostream>
using namespace std;
#include "swap.hpp"

int main()
{
	int a, b = 1;
	swap(a, b);
	cout << a << ' ' << b << '\n\n';

	double c = 3.3, d;
	swap(c, d);
	cout << c << ' ' << d << '\n\n';

	char e = 'e', f = 'f';
	swap(&e, &f);
	cout << e << ' ' << f << '\n\n';

	char* str1 = "string 1", str2 = "string 2";
  swap(str1, str2);
  cout << str1 << ' ' << str2 << '\n\n';

  return 0;
}
