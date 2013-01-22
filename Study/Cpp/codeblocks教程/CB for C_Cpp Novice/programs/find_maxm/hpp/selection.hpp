// selection.hpp
#ifndef SELECTION_HPP_
#define SELLECION_HPP_

#include <vector>
#include <algorithm>
#include <functional>
#include "readfrfile.hpp"

// ʹ�ö���ѽ���ɸѡ������ɸѡ����ݴ浽��������
void collect(std::vector<std::size_t>& v, std::vector<std::size_t>& b, std::size_t m)
{
	if(m < b.size())
	  std::partial_sort(b.begin(), b.begin() + m, b.end(), std::greater<std::size_t>());
	v.insert(v.end(), b.begin(), b.begin() + m); // ���ӵ��ϴδ�Ž���ĺ���
}

// ÿ�δ��ļ���ȡһ�У�ת����������ɸ��m�����ĺ�ѡֵ�ݴ�������
// ����ɸ��ϣ�Ȼ����ж���ɸѡ���ҳ����յ�m�����ֵ
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
