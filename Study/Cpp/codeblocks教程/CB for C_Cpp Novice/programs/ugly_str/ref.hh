// ref.hh
#include <iostream>
#include "cstr.hpp"
void test_ref()
{
	cstr_wrapper s1;
	std::cout << s1 << '\n';

	cstr_wrapper s2("1234567890.");
	std::cout << s2 << '\n';

	char str[] = "another test!";
	cstr_wrapper s3(str);
	std::cout << s3 << '\n';
	s3[0] = 'A';
	std::cout << (str == s3 ?
		"str == s3" : "str != s3") << '\n';
	std::cout << (s2 < s3 ?
		"s2 < s3" : "s2 >= s3") << '\n';
}
