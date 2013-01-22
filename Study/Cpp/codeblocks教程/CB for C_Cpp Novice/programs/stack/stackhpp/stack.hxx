// stack.hxx
#ifndef STACK_HXX_
#define STACK_HXX_

#include <iostream>
#include <stdexcept>
#include <cstdlib>
#include <cstring>

template <class T>                        // T������POD����
class Stack
{
public:
  typedef unsigned long size_type;
  typedef T& reference;
  typedef const T& const_reference;
public:
  Stack() : cap(SZ), sz(0), data(get(cap)) {}
  Stack(unsigned n, const T& d = T()) : cap(SZ), sz(n)
  {
    while(cap < sz) cap <<= 1;
    data = get(cap);
    std::memset(data, d, tsize() * sz);
  }
  Stack(const Stack& st) : cap(st.cap), sz(st.sz), data(get(cap))
  {
    std::memcpy(data, st.data, sz * tsize());
  }
  ~Stack()
  {
    delete [] data;
    sz = cap = 0;
  }
  Stack& operator = (const Stack& s)      // ���Ը�ֵ
  {
    if(this != &s)
    {
    	if(sz < s.cap)
    	{
        delete [] data;
        cap = s.cap;
        data = get(cap);
    	}
			sz = s.sz;
      std::memcpy(data, s.data, sz * tsize());
    }
    return *this;
  }
  unsigned size() const  { return sz; }   // ջ��Ԫ�ظ���
  bool empty() const  { return 0 == sz; } // ջ�Ƿ��
  const T& top()const                     // ջ��Ԫ��
  {
    if (sz < 1) Underflow_Error();
    return data[sz - 1];
  }
  T& top()
  {
    if(sz < 1) Underflow_Error();
    return data[sz - 1];
  }
  void push(const T& d)                   // ��ջ
  {
    if(sz + 1 > cap)
      rebuild();
    data[sz++] = d;
  }
  void pop()                              // ɾ��ջ��Ԫ��
  {
    if(sz < 1) Underflow_Error();
    --sz;
  }
  bool operator == (const Stack& st) const
  {
    return 0 == std::memcmp(data, st.data, sz * tsize());
  }

  bool operator < (const Stack& st) const
  {
    return std::memcmp(data, st.data, sz * tsize()) < 0;
  }
  void swap(Stack& s)                     // ��������ջ
  {
    unsigned t;
    t = cap, cap = s.cap, s.cap = t;
    t = sz, sz = s.sz, s.sz = t;
    T* d;
    d = data, data = s.data, s.data = d;
  }
protected:
  T* get(unsigned n)                      // �����ڴ�
  {
    T* p;
    try { p = new T[n]; }
    catch(const std::bad_alloc& ba)
    {
      std::cerr << ba.what();
      throw;
    }
    return p;
  }
  void rebuild()                          // ջ����Ϊԭ����2��
  {
    cap <<= 1;
    T* p = get(cap);
    std::memcpy(p, data, sz * tsize());
    delete [] data;
    data = p;
  }
private:
  void Underflow_Error() { throw std::underflow_error("Stack underflowed"); }
  unsigned tsize() const { return sizeof(T); }
  static const unsigned SZ = 1;
  unsigned cap, sz;
  T* data;
};

#endif
