// selection.hpp
#ifndef SELECTION_HPP_
#define SELLECION_HPP_

#include <vector>
#include <algorithm>
#include <functional>
#include "readfrfile.hpp"

// 使用二叉堆进行筛选，并把筛选结果暂存到缓冲区中
void collect(std::vector<std::size_t>& v, std::vector<std::size_t>& b, std::size_t m)
{
	if(m < b.size())
	  std::partial_sort(b.begin(), b.begin() + m, b.end(), std::greater<std::size_t>());
	v.insert(v.end(), b.begin(), b.begin() + m); // 附加到上次存放结果的后面
}

// 每次从文件读取一行，转化成整数，筛出m个最大的候选值暂存起来，
// 待粗筛完毕，然后进行二次筛选，找出最终的m个最大值
void maxinbuff(std::ifstream& fin, std::size_t m, std::size_t bsz,
               std::vector<std::size_t>& v)
{
	std::vector<std::size_t> buff;
	buff.reserve(bsz);
	while(!fin.eof())
	{
    readfrfile(fin, buff);
    collect(v, buff, m);
    buff.clear();
	}
	fin.close();
	if(m < v.size())
    std::nth_element(v.begin(), v.begin() + m, v.end(), std::greater<std::size_t>());
}

#endif
