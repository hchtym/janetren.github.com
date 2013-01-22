#ifndef MAX1K_OK_HPP_
#define MAX1K_OK_HPP_

#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <cstddef>
#include "../hpp/readfrfile.hpp"

// 把文件内容读入到缓冲区
void file2buff(const std::string& filename, std::vector<std::size_t>& v)
{
	std::ifstream fin(filename.c_str());
	while(!fin.eof())
	  readfrfile(fin, v);
}

// 两种方法检查结果是否一致, 一致说明正确, 否则需要调试源程序
bool max1k_ok(const std::string& file1, const std::string& file2, std::size_t sz)
{
	std::vector<std::size_t> v1, v2;
	file2buff(file1, v1);
	file2buff(file2, v2);
	#if defined FIND_MAXM_DEBUG
	std::cout << "size of 1st file: " << v1.size()
						<< ", size of 2nd file: " << v2.size() << '\n';
	if(v2.size() != sz)
	  return false;
	#endif
	std::partial_sort(v1.begin(), v1.begin() + sz, v1.end(), std::greater<std::size_t>());
	std::sort(v2.begin(), v2.end(), std::greater<std::size_t>());
  return std::equal(v2.begin(), v2.end(), v1.begin());
}

#endif
