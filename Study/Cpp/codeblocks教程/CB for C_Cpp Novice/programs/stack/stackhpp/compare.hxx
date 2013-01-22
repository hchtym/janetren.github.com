// compare.hxx
#ifndef COMPARE_HXX_
#define COMPARE_HXX_

// ����Ƚ��κοɱȵ����ͽ�����Ҫ����==��<�����
// Ȼ��������¶�����൱��Ҳ������!=, <=, >, >=

template <typename T>
bool operator != (const T& x, const T& y) { return !(x == y); }

template <typename T>
bool operator <= (const T& x, const T& y) { return !(y < x); }

template <typename T>
bool operator > (const T& x, const T& y) { return y < x; }

template <typename T>
bool operator >= (const T& x, const T& y) { return !(x < y); }

#endif
