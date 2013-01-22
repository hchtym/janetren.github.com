// write2file.hpp
#ifndef WRITE2FILE_HPP_
#define WRITE2FILE_HPP_

#include <fstream>
#include <vector>
#include "../hpp/random.hpp"

// 把缓冲区中的前n个数据写入到文件中，然后写入一个换行符
void buff2file(std::ofstream& fout, const std::vector<std::size_t>& v, std::size_t n)
{
	if(v.empty())
	  return;
  for(std::size_t i = 0; i < n; ++i)
    fout << v[i] << ' ';
	fout << '\n';
}

// 产生n个随机整数分批写入到一个文件中，每批写入bsz个
void rand2file(std::ofstream& fout, std::size_t n, std::size_t bsz)
{
	std::vector<std::size_t> v;
	v.reserve(bsz);
	for(std::size_t c = 0, b = n / bsz; c < b; ++c)
	{
	  gen_rand(v, bsz);
	  buff2file(fout, v, bsz);
	  v.clear();
	}
	const std::size_t L = n % bsz;
	if(0 != L)
	{
	  gen_rand(v, L);
	  buff2file(fout, v, L);
	  v.clear();
	}
	fout.close();
}


#endif

