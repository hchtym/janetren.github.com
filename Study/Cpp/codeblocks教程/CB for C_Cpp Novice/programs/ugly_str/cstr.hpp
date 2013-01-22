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

	unsigned size()const;           // �ַ����е��ַ�������������������
	bool empty()const;              // �ж��Ƿ�Ϊ�մ�
	char& operator [] (unsigned);   // ����ĳ���ַ���������±�
	const char& operator [] (unsigned) const;
	const char& at(unsigned) const; // ����ĳ���ַ�������±�
	const char* c_str() const;      // ת����C�����ַ���
	// ������Ա��������...
	// �ַ��ܱȽϣ�����<��==
	friend bool operator < (const cstr_wrapper&, const cstr_wrapper&);
	friend bool operator == (const cstr_wrapper&, const cstr_wrapper&);
	// ����ַ��ܣ�����<<
	friend std::ostream& operator << (std::ostream&, const cstr_wrapper&);

private:
	char* p;
};

// ���캯��
cstr_wrapper::cstr_wrapper(const char* str) : p(const_cast<char*>(str)) {}
cstr_wrapper::cstr_wrapper(const cstr_wrapper& s) : p(s.p) {}
//�ַ��ܴ�С���Լ�ȡĳ���ַ�(������±�)
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
// ȡĳ���ַ�ʱ�����±���м��
const char& cstr_wrapper::at(unsigned i) const
{
	if(i < std::strlen(p))
		return p[i];
	else
		throw std::out_of_range("subscript error");
}
// ת����C�����ַ���
const char* cstr_wrapper::c_str() const
{
	return p;
}
// �ж��ַ��ܴ�С
bool operator < (const cstr_wrapper& s1, const cstr_wrapper& s2)
{
	return std::strcmp(s1.p, s2.p) < 0;
}
// �ж��ַ����Ƿ����
bool operator == (const cstr_wrapper& s1, const cstr_wrapper& s2)
{
	return 0 == std::strcmp(s1.p, s2.p);
}
// ���һ���ַ���
std::ostream& operator << (std::ostream& os, const cstr_wrapper& s)
{
	return os << s.p;
}

#endif
