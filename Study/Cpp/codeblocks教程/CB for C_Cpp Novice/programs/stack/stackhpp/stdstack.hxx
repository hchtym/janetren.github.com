#include <deque>
#include "compare.hxx"
template <class T, class Sequence = std::deque<T> > // Ĭ��ʹ��std::vector���Ԫ��
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
  bool empty() { return c.empty(); }                 // �Ƿ��
  size_type size() { return c.size(); }              // ���ٸ�Ԫ��
  reference top() { return c.back(); }               // ����ջ��Ԫ��
  const_reference top() const { return c.back(); }
  void push(const value_type& x) { c.push_back(x); } // ѹ��ջ
  void pop() { c.pop_back(); }                       // ɾ��ջ��Ԫ��
  // ����==�ж�����ջ�Ƿ��࣬����<�ж�����ջ��С
  friend bool operator == (const Stack& x, const Stack& y) { return x.c == y.c; }
  friend bool operator < (const Stack& x, const Stack& y) { return x.c < y.c; }
  void swap(Stack& st) { c.swap(st.c); }             // ͨ������������������ջ
};
