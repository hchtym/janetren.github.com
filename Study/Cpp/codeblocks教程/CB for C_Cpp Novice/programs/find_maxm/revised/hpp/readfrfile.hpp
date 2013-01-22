// readfrfile.hpp
#ifndef READFRFILE_HPP_
#define READFRFILE_HPP_

#include <fstream>
#include <string>
#include <cstring>
#include <vector>

// ���ַ���ת�����޷�������
inline std::size_t str2uint(const std::string& str)
{
  std::size_t n = 0;
  for(std::size_t i = 0; i < str.size(); ++i)
  {
  	n *= 10;
  	n += (str[i] - '0');
  }
  return n;
}

// ���������ַ���ת���ɵ�������д�뻺����
void str2buff(const std::string& str, std::vector<std::size_t>& v)
{
  for(std::size_t i = 0, k = 0; i < str.size(); i = k + 1)
  {
  	while(!std::isdigit(str[i]) && i < str.size()) ++i;
  	for(k = i; k < str.size() && std::isdigit(str[k]); ++k);
  	if(i < k)
  	{
  	  std::string tmp(std::string(&str[i], &str[k]));
  	  v.push_back(str2uint(tmp));
  	}
  }
}

// ÿ�δ��ļ��ж�ȡһ�У���������ת��������д�뻺����
inline void readfrfile(std::ifstream& fin, std::vector<std::size_t>& buff)
{
  std::string str;
  std::getline(fin, str);
  str2buff(str, buff);
}

#endif
