// 用fibonacci引擎产生位于区间[LOW, HIGH)的随机整数, uniform分布
// test4.cpp

#include <iostream>
#include <cstdlib>
#include <boost/random.hpp>

int main()
{
	const unsigned long SZ = 100, LOW = 0, HIGH = 31;
  boost::lagged_fibonacci607 rng;
  boost::uniform_int<> ui(LOW, HIGH);
  boost::variate_generator<boost::lagged_fibonacci607&,
		boost::uniform_int<> > die(rng, ui);
  for(unsigned long i = 0; i < SZ; ++i)
    std::cout << die() << ' ';
	std::cout << '\n';

	std::system("PAUSE");
	return 0;
}
