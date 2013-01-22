// test_string.cc
#include <cstdlib>
#include <string>
#include <iostream>
#include "stack_clear.hpp"

void rand_str(std::string& str) // 产生随机字符窜，仅仅是字母和数字的组合
{
  const std::string
    carr("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
  for(std::string::size_type i = std::rand() % 75; i > 0; --i)
    str.push_back(carr[std::rand() % carr.size()]);
}
void test_string() // 测试stack<std::string>各个成员函数以及比较运算符
{
  typedef Stack<std::string>::size_type size_type;

  std::cout << "test strings:\n";
  //std::srand(std::time(0));
  const size_type M = 11, SZ1 = rand() % M, SZ2 = std::rand() % M;
  Stack<std::string> sts1, sts2;
  std::string str;
  // 用随机字符窜填充stack<std::string> sts1
  for(unsigned i = 0; i < SZ1; ++i)
  {
    rand_str(str);
    sts1.push(str);
    str.clear();
  }

  for(unsigned i = 0; i < SZ2; ++i)
  {
    rand_str(str);
    sts2.push(str);
    str.clear();
  }

  std::cout << "size of Stack: " << sts1.size() << ' ' << sts2.size() << '\n';
  std::cout << "top element: " << (sts1.empty() ? "" : sts1.top()) << '\n';
  std::cout << "top element: " << (sts2.empty() ? "" : sts2.top()) << '\n';
  std::cout << "comparing Stack sts1 and sts2:\n";
  std::cout << (sts1 != sts2 ? "sts1 != sts2" : "sts1 == sts2") << '\n';
  std::cout << (sts1 > sts2 ? "sts1 > sts2" : "sts1 <= sts2") << '\n';
  std::cout << (sts1 >= sts2 ? "sts1 >= sts2" : "sts1 < sts2") << '\n';
  sts2.swap(sts1);
  std::cout << (sts1 <= sts2 ? "sts1 <= sts2" : "sts1 > sts2") << '\n';

  stack_clear(sts1);
  stack_clear(sts2);
  std::cout << "strings test ok!\n\n";
}
