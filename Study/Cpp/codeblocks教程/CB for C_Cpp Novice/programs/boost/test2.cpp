// ÔÚÖÕ¶ËÊä³ö[2](2,8)
// test2.cpp

#include <boost/numeric/ublas/vector.hpp>
#include <boost/numeric/ublas/matrix.hpp>
#include <boost/numeric/ublas/io.hpp>
#include <iostream>

int main()
{
	using namespace boost::numeric::ublas;
	vector<double> x(2);
	x(0) = 1; x(1) = 2;
	matrix<double> A(2, 2);
	A(0, 0) = 0; A(0, 1) = 1;
	A(1, 0) = 2; A(1, 1) = 3;
	vector<double> y = prod(A, x);
	std::cout << y << std::endl;
	return 0;
}
