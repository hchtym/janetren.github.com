// ���ն˽���һ����������, ����3��������ն�
// test1.cpp

#include <iostream>
#include <iterator>
#include <algorithm>
#include <boost/lambda/lambda.hpp>

int main()
{
  using namespace boost::lambda;
	typedef std::istream_iterator<int> in;
  std::for_each(in(std::cin), in(), std::cout << (_1 * 3) << ' ');
  return 0;
}
