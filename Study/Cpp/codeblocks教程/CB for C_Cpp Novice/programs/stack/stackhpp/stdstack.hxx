#include <deque>
#include "compare.hxx"
template <class T, class Sequence = std::deque<T> > // 默认使用std::vector存放元素
class Stack
{
public:
  typedef typename Sequence::value_type value_type;  // T
  typedef typename Sequence::size_type size_type;    // size_t
  typedef typename Sequence::reference reference;    // T&
  typedef typename Sequence::const_reference const_reference; // const T&
protected:
  Sequence c;
public:
  Stack() : c() {}
  explicit Stack(const Sequence& container) : c(container) {}
  bool empty() { return c.empty(); }                 // 是否空
  size_type size() { return c.size(); }              // 多少个元素
  reference top() { return c.back(); }               // 引用栈顶元素
  const_reference top() const { return c.back(); }
  void push(const value_type& x) { c.push_back(x); } // 压入栈
  void pop() { c.pop_back(); }                       // 删除栈顶元素
  // 重载==判断两个栈是否相，重载<判断两个栈大小
  friend bool operator == (const Stack& x, const Stack& y) { return x.c == y.c; }
  friend bool operator < (const Stack& x, const Stack& y) { return x.c < y.c; }
  void swap(Stack& st) { c.swap(st.c); }             // 通过交换容器交换两个栈
};
