#include <cstddef>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctime>
#include <cstddef>
#include "hpp/write2file.hpp"
#include "hpp/selection.hpp"
#include "test/max1k_ok.hpp"

int main()
{
	const std::size_t SZ = 1000000;    // 产生SZ个随机数
  const std::size_t M = 1 << 10;      // 找出M个最大的
  const std::size_t BSZ = 1 << 20;    // 缓存大小为BSZ个元素空间
  std::string tofile1, tofile2;
  std::cout << "input a file name to create for holding random numbers: ";
  std::getline(std::cin, tofile1);
  std::ofstream fout(tofile1.c_str());
  std::clock_t time = std::clock();
  rand2file(fout, SZ, BSZ);           // 把SZ个随机数写到磁盘上
  std::cout << "generating " << SZ << " numbers and writing them into "
            << tofile1 << " used: " << std::clock() - time << "ms\n";

  std::clock_t t = std::clock();
  std::ifstream fin(tofile1.c_str());
  std::vector<std::size_t> buff;
  maxinbuff(fin, M, BSZ, buff);       // 找到的最大M个随机数暂存缓冲区
  std::cout << "finding " << M << " maximum numbers in " << tofile1
            << " used: " << std::clock() - t << "ms\n";

  std::cout << "input a file name to create for holding maximum numbers: ";
  std::getline(std::cin, tofile2);
  fout.open(tofile2.c_str());
  buff2file(fout, buff, M);           // 把最大的M个随机数写到磁盘上
  std::cout << (max1k_ok(tofile1, tofile2, M) ? "SUCCEED" : "FAILED") << '\n';
}
