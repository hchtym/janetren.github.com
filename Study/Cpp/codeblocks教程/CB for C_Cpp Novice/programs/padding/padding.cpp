// padding.cpp
#include <iostream>
#include "padding.hpp"

int main()
{
	padding a;
	std::cout << "sizeof(padding) == " << sizeof(padding) << '\n';
	std::cout << "(sizeof(char) + sizeof(int) + sizeof(double)) == "
	          << sizeof(char) + sizeof(int) + sizeof(double) << '\n'

  char* p = (char*)(&a);
  int int_len = sizeof(int);
	std::cout << "1st element: " << *p << '\n';
	std::cout << "2nd element: " << *(int*)(p + int_len) << '\n';
	std::cout << "3rd element: " << *(double*)(p + (int_len << 1)) << '\n';

	return 0;
}
