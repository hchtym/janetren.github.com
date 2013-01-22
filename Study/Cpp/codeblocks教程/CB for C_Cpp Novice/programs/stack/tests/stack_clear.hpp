// stack_clear.hpp
#ifndef STACK_CLEAR_HPP_
#define STACK_CLEAR_HPP_
#include "../stackhpp/stack.hpp"

// ���һ��ջ
template <typename T>
void stack_clear(Stack<T>& s)
{
  if(!s.empty())
  {
	  Stack<T> st; // ����һ����ʱ��ջ
	  st.swap(s);  // s�洢st��Ԫ�أ����ѿ�
  } // st�Ѿ�������
}

#endif
