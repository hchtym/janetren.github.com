#ifndef MAX1K_OK_HPP_
#define MAX1K_OK_HPP_

#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <cstddef>
#include "../hpp/readfrfile.hpp"

void file2buff(std::ifstream& fin, std::vector<std::size_t>& v)
{
	std::string str;
	while(!fin.eof())
	{
		std::getline(fin, str);
    str2buff(str, v);
    str.clear();
	}
	fin.close();
}

bool max1k_ok(const std::string& file1, const std::string& file2, std::size_t sz)
{
	std::vector<std::size_t> v1, v2;
	std::ifstream fin1(file1.c_str()), fin2(file2.c_str());
	file2buff(fin1, v1);
	std::partial_sort(v1.begin(), v1.begin() + sz, v1.end(), std::greater<std::size_t>());
	file2buff(fin2, v2);
	std::sort(v2.begin(), v2.end(), std::greater<std::size_t>());
  return std::equal(v2.begin(), v2.end(), v1.begin());
}

#endif
