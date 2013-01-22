// cstr.hpp
#ifndef CSTR_WRAPPER_HPP_
#define CSTR_WRAPPER_HPP_

#include <cstring>
#include <iostream>
#include <stdexcept>

class cstr_wrapper
{
public:
	cstr_wrapper(const char* str = 0);
	cstr_wrapper(const cstr_wrapper&);

	unsigned size()const;           // 字符窜中的字符个数，不包括结束符
	bool empty()const;              // 判断是否为空窜
	char& operator [] (unsigned);   // 引用某个字符，不检查下标
	const char& operator [] (unsigned) const;
	const char& at(unsigned) const; // 引用某个字符，检查下标
	const char* c_str() const;      // 转换成C风格的字符窜
	// 其它成员函数，略...
	// 字符窜比较，重载<和==
	friend bool operator < (const cstr_wrapper&, const cstr_wrapper&);
	friend bool operator == (const cstr_wrapper&, const cstr_wrapper&);
	// 输出字符窜，重载<<
	friend std::ostream& operator << (std::ostream&, const cstr_wrapper&);

private:
	char* p;
};

// 构造函数
cstr_wrapper::cstr_wrapper(const char* str) : p(const_cast<char*>(str)) {}
cstr_wrapper::cstr_wrapper(const cstr_wrapper& s) : p(s.p) {}
//字符窜大小，以及取某个字符(不检查下标)
unsigned cstr_wrapper::size() const
{
	return std::strlen(p);
}
bool cstr_wrapper::empty() const
{
	return 0 == std::strcmp(p, "");
}
const char& cstr_wrapper::operator [] (unsigned i) const
{
	return p[i];
}
char& cstr_wrapper::operator [] (unsigned i)
{
	return p[i];
}
// 取某个字符时，对下标进行检查
const char& cstr_wrapper::at(unsigned i) const
{
	if(i < std::strlen(p))
		return p[i];
	else
		throw std::out_of_range("subscript error");
}
// 转换成C风格的字符窜
const char* cstr_wrapper::c_str() const
{
	return p;
}
// 判断字符窜大小
bool operator < (const cstr_wrapper& s1, const cstr_wrapper& s2)
{
	return std::strcmp(s1.p, s2.p) < 0;
}
// 判断字符窜是否相等
bool operator == (const cstr_wrapper& s1, const cstr_wrapper& s2)
{
	return 0 == std::strcmp(s1.p, s2.p);
}
// 输出一个字符窜
std::ostream& operator << (std::ostream& os, const cstr_wrapper& s)
{
	return os << s.p;
}

#endif
