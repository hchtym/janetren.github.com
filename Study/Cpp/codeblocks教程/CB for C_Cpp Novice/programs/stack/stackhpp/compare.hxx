// compare.hxx
#ifndef COMPARE_HXX_
#define COMPARE_HXX_

// 定义比较任何可比的类型仅仅需要重载==和<运算符
// 然后包含以下定义就相当于也定义了!=, <=, >, >=

template <typename T>
bool operator != (const T& x, const T& y) { return !(x == y); }

template <typename T>
bool operator <= (const T& x, const T& y) { return !(y < x); }

template <typename T>
bool operator > (const T& x, const T& y) { return y < x; }

template <typename T>
bool operator >= (const T& x, const T& y) { return !(x < y); }

#endif
