// test_int.cc
#include <cstdlib>
#include <iostream>
#include "stack_clear.hpp"

void test_int() // 测试stack<int>各个成员函数以及比较运算符
{
  typedef Stack<int>::size_type size_type;

  std::cout << "test integers:\n";
  //std::srand(std::time(0));
  const size_type M = 11, SZ1 = std::rand() % M, SZ2 = std::rand() % M;
  Stack<int> sti1, sti2;
  // 用随机数填充Stack<int> sti1
  for(size_type i = 0; i < SZ1; ++i)
    sti1.push(std::rand());
  for(size_type i = 0; i < SZ2; ++i)
    sti2.push(std::rand());

  std::cout << "size of Stack: " << sti1.size() << ' ' << sti2.size() << '\n';
  std::cout << "top element: ";
  if(!sti1.empty())
    std::cout << sti1.top() << ' ';
  if(!sti2.empty())
    std::cout << sti2.top() << '\n';
  std::cout << "comparing Stack sti1 and sti2:\n";
  std::cout << (sti1 != sti2 ? "sti1 != sti2" : "sti1 == sti2") << '\n';
  std::cout << (sti1 > sti2 ? "sti1 > sti2" : "sti1 <= sti2") << '\n';
  std::cout << (sti1 >= sti2 ? "sti1 >= sti2" : "sti1 < sti2") << '\n';
  sti2.swap(sti1);
  std::cout << (sti1 <= sti2 ? "sti1 <= sti2" : "sti1 > sti2") << '\n';

  stack_clear(sti1);
  stack_clear(sti2);
  std::cout << "integers test ok!\n\n";
}
