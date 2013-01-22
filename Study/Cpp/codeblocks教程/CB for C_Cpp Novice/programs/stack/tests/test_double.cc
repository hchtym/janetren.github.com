// test_double.cc
#include <cstdlib>
#include <iostream>
#include "stack_clear.hpp"

void test_double() // 测试stack<double>各个成员函数以及比较运算符
{
  typedef Stack<double>::size_type size_type;

  std::cout << "test real numbers:\n";
  //std::srand(std::time(0));
  const size_type M = 11, SZ1 = std::rand() % M, SZ2 = std::rand() % M;
  Stack<double> std1, std2;
  // 用随机浮点数填充Stack<double> std1
  for(size_type i = 0; i < SZ1; ++i)
    std1.push(static_cast<double>(std::rand()) / RAND_MAX);
  for(size_type i = 0; i < SZ2; ++i)
    std2.push(static_cast<double>(std::rand()) / RAND_MAX);

  std::cout << "size of Stack: " << std1.size() << ' ' << std2.size() << '\n';
  std::cout << "top element: ";
  if(!std1.empty())
    std::cout << std1.top()<< ' ';
  if(!std2.empty())
    std::cout << std2.top() << '\n';
  std::cout << "comparing Stack std1 and std2:\n";
  std::cout << (std1 != std2 ? "std1 != std2" : "std1 == std2") << '\n';
  std::cout << (std1 > std2 ? "std1 > std2" : "std1 <= std2") << '\n';
  std::cout << (std1 >= std2 ? "std1 >= std2" : "std1 < std2") << '\n';
  std2.swap(std1);
  std::cout << (std1 <= std2 ? "std1 <= std2" : "std1 > std2") << '\n';

  stack_clear(std1);
  stack_clear(std2);
  std::cout << "floating points test ok!\n\n";
}

