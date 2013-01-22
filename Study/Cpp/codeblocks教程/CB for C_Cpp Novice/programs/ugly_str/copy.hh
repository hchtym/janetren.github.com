// copy.hh
#include "cstr.hpp"
cstr_wrapper test_copy1()
{
  char str[] = "copy a char[] string.";
  return cstr_wrapper(str);
}

cstr_wrapper test_copy2()
{
  const char* str = "copy a char* string.";
  return cstr_wrapper(str);
}

#include <iostream>
void test_copy()
{
  cstr_wrapper str1 = test_copy1();
  std::cout << str1 << ' ';
  str1[0] = 'C';
  std::cout << str1 << '\n';

  cstr_wrapper str2 = test_copy2();
  std::cout << str2 << '\n';
}
