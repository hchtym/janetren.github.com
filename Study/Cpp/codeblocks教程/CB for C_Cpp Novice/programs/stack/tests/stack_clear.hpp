// stack_clear.hpp
#ifndef STACK_CLEAR_HPP_
#define STACK_CLEAR_HPP_
#include "../stackhpp/stack.hpp"

// 清空一个栈
template <typename T>
void stack_clear(Stack<T>& s)
{
  if(!s.empty())
  {
	  Stack<T> st; // 建立一个临时空栈
	  st.swap(s);  // s存储st的元素，现已空
  } // st已经被销毁
}

#endif
