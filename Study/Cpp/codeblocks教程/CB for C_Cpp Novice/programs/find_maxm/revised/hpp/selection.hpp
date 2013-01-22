// selection.hpp
#ifndef SELECTION_HPP_
#define SELLECION_HPP_

#include <vector>
#include <algorithm>
#include <functional>
#include "readfrfile.hpp"

// 使用二叉堆进行筛选，并把筛选结果暂存到缓冲区中
void select(std::vector<std::size_t>& v, std::vector<std::size_t>& b, std::size_t m)
{
	if(m < b.size())
	{
	  std::partial_sort(b.begin(), b.begin() + m, b.end(), std::greater<std::size_t>());
	  v.insert(v.end(), b.begin(), b.begin() + m); // 附加到上次存放结果的后面
	}
	else
	  v.insert(v.end(), b.begin(), b.end());
}

// 每次从文件读取一行，转化成整数，筛出m个最大的候选值暂存起来，
// 待粗筛完毕，然后进行二次筛选，找出最终的m个最大值
void maxinbuff(const std::string& filename, std::size_t m, std::size_t bsz,
               std::vector<std::size_t>& v)
{
	std::ifstream fin(filename.c_str());
	#if defined FIND_MAXM_DEBUG
	unsigned long flen = 0;
	#endif
	std::vector<std::size_t> buff;
	buff.reserve(bsz);
	while(!fin.eof())
	{
    readfrfile(fin, buff);
		#if defined FIND_MAXM_DEBUG
	  flen += buff.size();
	  #endif
	  if(!buff.empty())
	  {
      select(v, buff, m);
      buff.clear();
	  }
	}
	#if defined FIND_MAXM_DEBUG
	std::cout << "file length: " << flen << ", selected: " << v.size() << '\n';
	bool flen_tag = false;
	unsigned long mod = flen % bsz;
	if(0 == mod)
	  flen_tag = (flen / bsz * m == v.size());
	else if(mod > m)
	  flen_tag = ((flen / bsz + 1) * m == v.size());
	else
	  flen_tag = (flen / bsz * m + mod == v.size());
	std::cout << "file length test " << (flen_tag ? "passed" : "failed") << '\n';
	#endif
	if(m < v.size())
    std::nth_element(v.begin(), v.begin() + m, v.end(), std::greater<std::size_t>());
}

#endif
