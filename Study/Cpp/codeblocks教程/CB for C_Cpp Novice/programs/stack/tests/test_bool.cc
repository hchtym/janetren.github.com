// test_bool.cc
#include <cstdlib>
#include <iostream>
#include "stack_clear.hpp"

void test_bool() // 测试Stack<bool>成员函数以及比较运算符
{
  typedef Stack<bool>::size_type size_type;

  std::cout << "test booleans:\n";
  const size_type M = 11, SZ1 = std::rand() % M, SZ2 = std::rand() % M;
  Stack<bool> stb1, stb2;
  // 用bool值true或者false填充stb1
  for(size_type i = 0; i < SZ1; ++i)
    stb1.push(std::rand() & 1);
  for(size_type i = 0; i < SZ2; ++i)
    stb2.push(std::rand() & 1);

  std::cout << "size of Stack: " << stb1.size() << ' ' << stb2.size() << '\n';
  std::cout << "top element: ";
  std::cout << (stb1.empty() ? "" : (stb1.top() == true ? "true" : "false")) << ' ';
  std::cout << (stb2.empty() ? "" : (stb2.top() == true ? "true" : "false")) << '\n';
  std::cout << "comparing Stack stb1 and stb2:\n";
  std::cout << (stb1 != stb2 ? "stb1 != stb2" : "stb1 == stb2") << '\n';
  std::cout << (stb1 > stb2 ? "stb1 > stb2" : "stb1 <= stb2") << '\n';
  std::cout << (stb1 >= stb2 ? "stb1 >= stb2" : "stb1 < stb2") << '\n';
  stb2.swap(stb1);
  std::cout << (stb1 <= stb2 ? "stb1 <= stb2" : "stb1 > stb2") << '\n';

  stack_clear(stb1);
  stack_clear(stb2);
  std::cout << "booleans test ok!\n\n\n";
}

