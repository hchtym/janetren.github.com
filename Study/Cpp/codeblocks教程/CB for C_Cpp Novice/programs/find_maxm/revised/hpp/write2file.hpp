// write2file.hpp
#ifndef WRITE2FILE_HPP_
#define WRITE2FILE_HPP_

#include <fstream>
#include <vector>
#include "../hpp/random.hpp"

// �ѻ������е�ǰn������д�뵽�ļ��У�Ȼ��д��һ�����з�
void buff2file(std::ofstream& fout, const std::vector<std::size_t>& v, std::size_t n)
{
	#if defined FIND_MAXM_DEBUG
	if(v.size() < n)
	  std::cout << " numbers insufficient\n";
	#endif
  for(std::size_t i = 0; i < n; ++i)
    fout << v[i] << ' ';
	fout << '\n';
}

 inline void max2file(const std::string& tofile, const std::vector<std::size_t>& v,
                      std::size_t n)
 {
 	  std::ofstream fout(tofile.c_str());
 	  buff2file(fout, v, n);
 }
// ����n�������������д�뵽һ���ļ��У�ÿ��д��bsz��
void rand2file(const std::string& tofile, std::size_t n, std::size_t bsz)
{
	std::ofstream fout(tofile.c_str());
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
}


#endif

