#define FIND_MAXM_DEBUG               // �����ú�

#include <cstddef>
#include <iterator>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctime>
#include "hpp/write2file.hpp"
#include "hpp/selection.hpp"
#include "test/max1k_ok.hpp"

int main()
{
	const std::size_t SZ = 10000000;    // ����SZ�������
  const std::size_t M = 1 << 10;      // �ҳ�M������
  const std::size_t BSZ = 1 << 20;    // �����СΪBSZ��Ԫ�ؿռ�
  std::string tofile1, tofile2;
  std::cout << "input a file name to create for holding random numbers: ";
  std::getline(std::cin, tofile1);
  std::clock_t time = std::clock();
  rand2file(tofile1, SZ, BSZ);        // ��SZ�������д��������
  std::cout << "generating " << SZ << " numbers and writing them into "
            << tofile1 << " used: " << std::clock() - time << "ms\n";

  std::clock_t t = std::clock();
  std::vector<std::size_t> buff;
  maxinbuff(tofile1, M, BSZ, buff);   // �ҵ������M��������ݴ滺����
  std::cout << "finding " << M << " maximum numbers in " << tofile1
            << " used: " << std::clock() - t << "ms\n";

  std::cout << "input a file name to create for holding maximum numbers: ";
  std::getline(std::cin, tofile2);
  max2file(tofile2, buff, M);         // ������M��������д��������
  std::cout << "testing is in progress... "
            << (max1k_ok(tofile1, tofile2, M) ? "PASSED" : "FAILED") << '\n';
}
